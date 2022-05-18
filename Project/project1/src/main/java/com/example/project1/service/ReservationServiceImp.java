package com.example.project1.service;

import com.example.project1.DTO.LessonDTO;
import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.HistoryEntity;
import com.example.project1.domain.LessonEntity;
import com.example.project1.domain.ParentEntity;
import com.example.project1.domain.repo.*;
import com.example.project1.util.TimeHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReservationServiceImp implements ReservationService{
    private final ParentRepo parentRepo;
    private final IslandRepo islandRepo;
    private final ReservationRepo reservationRepo;
    private final LessonRepo lessonRepo;
    private final HistoryRepo historyRepo;

    private final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImp.class);

    @Override
    public ReservationDTO createReservation(Long id, Date date, ParentDTO pdto, LessonDTO ldto, int number){
        return new ReservationDTO(id,date,pdto,ldto,number);
    }

    @Override
    public void makeReservation(ReservationDTO reservationDTO) {
        ParentDTO pdto = reservationDTO.getParent();
        LessonDTO ldto = reservationDTO.getLesson();
        
        if(parentRepo.existsById(pdto.getParentId()) && 
                lessonRepo.existsById(ldto.getLessonId()) &&
                !reservationRepo.existsByParentIdAndLessonId(pdto.getParentId(),ldto.getLessonId()) &&
                reservationDTO.getNumber() != 0
        ) {
            
            LOGGER.info("예약하기 서비스 호출");
            LOGGER.info("예약정보");
            LOGGER.info("{}", reservationDTO);

            Date rDate = reservationDTO.getDate();
            Date nowDay = TimeHelper.getInstance().changeDayOnly(new Date(), 1);
            Date maxDay = TimeHelper.getInstance().changeDayOnly(new Date(), 14);

            LOGGER.debug("날짜조건 확인");
            LOGGER.info("{} {}", nowDay, maxDay);
            if (rDate.after(nowDay) && rDate.before(maxDay)) {
                int number = reservationDTO.getNumber() + ldto.getCurrentNum();
                LOGGER.debug("예약정원 확인");
                if (number <= ldto.getMaxNum()) {
                    ldto.setCurrentNum(number);
                    LOGGER.info("{} 정원 업데이트", ldto.getLessonName());
                    lessonRepo.save(ldto.toEntity());

                    LOGGER.info("예약정보 저장");
                    reservationRepo.save(reservationDTO.toEntity());

                    LOGGER.info("예약기록 저장");
                    historyRepo.save(
                            HistoryEntity.builder()
                                    .date(nowDay)
                                    .parent(pdto.toEntity())
                                    .lesson(ldto.toEntity())
                                    .activity("C")
                                    .build()
                    );
                }
            }
        }
    }

    @Override
    public void cancelReservation(ReservationDTO reservation) {
        Date nowDay = new Date();
        ParentDTO pdto = reservation.getParent();
        LessonDTO ldto = reservation.getLesson();

        reservationRepo.delete(
                reservationRepo.findByParentIdAndLessonId(pdto.getParentId(),ldto.getLessonId())
        );
        historyRepo.save(
                HistoryEntity.builder()
                        .date(nowDay)
                        .parent(pdto.toEntity())
                        .lesson(ldto.toEntity())
                        .activity("D")
                        .build()
        );
    }

    @Override
    public List<ReservationDTO> getParentsSubscriber(Long parentId){
        List<ReservationDTO> result = new ArrayList<>();
        reservationRepo.findAllByParentId(
                parentRepo.findById(parentId).get().getId()
        ).forEach(e -> result.add(e.toDTO()));

        return result;
    }

    @Override
    public List<ReservationDTO> getIslandSubscriber(Long islandId) {
        List<ReservationDTO> result = new ArrayList<>();
        lessonRepo.findAllByIslandId(
                islandRepo.findById(islandId).get().getId()
        ).forEach(l -> {
            reservationRepo.findAllByLessonId(l.getId())
                    .forEach(e -> {
                        result.add(e.toDTO());
                    });
        });

        return result;
    }

    @Override
    public List<ReservationDTO> getLessonSubscriber(Long lessonId) {
        List<ReservationDTO> result = new ArrayList<>();
        reservationRepo.findAllByLessonId(
                lessonRepo.findById(lessonId).get().getId()
        ).forEach(e -> result.add(e.toDTO()));

        return result;
    }
}
