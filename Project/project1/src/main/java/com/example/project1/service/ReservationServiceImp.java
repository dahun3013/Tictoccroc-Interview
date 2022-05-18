package com.example.project1.service;

import com.example.project1.DTO.HistoryDTO;
import com.example.project1.DTO.LessonDTO;
import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;
import com.example.project1.common.error.CustomException;
import com.example.project1.domain.HistoryEntity;
import com.example.project1.domain.repo.*;
import com.example.project1.util.TimeHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.example.project1.common.enums.ErrorCode.*;

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
    public void makeReservation(ReservationDTO reservationDTO) {
        ParentDTO pdto = reservationDTO.getParent();
        LessonDTO ldto = reservationDTO.getLesson();
        if(!parentRepo.existsById(pdto.getParentId()) ||
                !lessonRepo.existsById(ldto.getLessonId()) ||
                reservationDTO.getNumber() == 0
        ){
            throw new CustomException(INVALID_DATA);
        }
        if(reservationRepo.existsByParentIdAndLessonId(pdto.getParentId(),ldto.getLessonId())){
            throw new CustomException(DUPLICATE_RESOURCE);
        }

            
        LOGGER.info("예약하기 서비스 호출");
        LOGGER.info("예약정보");
        LOGGER.info("{}", reservationDTO);

        Date rDate = reservationDTO.getDate();
        Date nowDay = TimeHelper.getInstance().changeDayOnly(new Date(), 1);
        Date maxDay = TimeHelper.getInstance().changeDayOnly(new Date(), 14);

        LOGGER.debug("날짜조건 확인");
        if (rDate.after(nowDay) && rDate.before(maxDay)) {
            int number = reservationDTO.getNumber() + ldto.getCurrentNum();
            LOGGER.debug("예약정원 확인");
            if (number <= ldto.getMaxNum()) {
                LOGGER.info("{} 수업 정원변경",ldto.getLessonName());
                ldto.setCurrentNum(number);
                lessonRepo.save(ldto.toEntity());

                LOGGER.info("예약정보 저장");
                reservationRepo.save(reservationDTO.toEntity());

                LOGGER.info("예약기록 저장");
                historyRepo.save(
                        HistoryEntity.builder()
                                .date(new Date())
                                .parent(pdto.toEntity())
                                .lesson(ldto.toEntity())
                                .activity("예약완료")
                                .build()
                );
            }
        }

    }

    @Override
    public void cancelReservation(ReservationDTO reservationDTO) {
        ParentDTO pdto = reservationDTO.getParent();
        LessonDTO ldto = reservationDTO.getLesson();
        if(!parentRepo.existsById(pdto.getParentId()) ||
                !lessonRepo.existsById(ldto.getLessonId()) ||
                reservationDTO.getNumber() == 0
        ){
            throw new CustomException(INVALID_DATA);
        }
        if(!reservationRepo.existsByParentIdAndLessonId(pdto.getParentId(),ldto.getLessonId())){
            throw new CustomException(NO_DATA);
        }

        LOGGER.info("예약취소 서비스 호출");
        LOGGER.info("예약정보");
        LOGGER.info("{}", reservationDTO);

        LOGGER.info("{} 수업 정원변경",ldto.getLessonName());
        ldto.setCurrentNum(ldto.getCurrentNum()-reservationDTO.getNumber());
        lessonRepo.save(ldto.toEntity());

        LOGGER.info("예약취소");
        reservationRepo.delete(
                reservationRepo.findByParentIdAndLessonId(pdto.getParentId(),ldto.getLessonId())
        );
        LOGGER.info("예약기록 저장");
        historyRepo.save(
                HistoryEntity.builder()
                        .date(new Date())
                        .parent(pdto.toEntity())
                        .lesson(ldto.toEntity())
                        .activity("예약취소")
                        .build()
        );
    }

    @Override
    public List<ReservationDTO> getParentsSubscriber(Long parentId){
        List<ReservationDTO> result = new ArrayList<>();
        LOGGER.info("부모별 예약현황");
        reservationRepo.findAllByParentId(
                parentRepo.findById(parentId).get().getId()
        ).forEach(e -> result.add(e.toDTO()));

        return result;
    }

    @Override
    public List<ReservationDTO> getIslandSubscriber(Long islandId) {
        List<ReservationDTO> result = new ArrayList<>();
        LOGGER.info("지점별 예약현황");
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
        LOGGER.info("수업별 예약현황");
        reservationRepo.findAllByLessonId(
                lessonRepo.findById(lessonId).get().getId()
        ).forEach(e -> result.add(e.toDTO()));

        return result;
    }

    @Override
    public List<HistoryDTO> getIslandHistory(Long islandId) {
        List<HistoryDTO> result = new ArrayList<>();
        LOGGER.info("지점별 예약이력");
        lessonRepo.findAllByIslandId(islandId).forEach(l ->{
            historyRepo.findAllByLessonId(l.getId()).forEach(e ->{
                result.add(e.toDTO());
            });
        });
        return result;
    }

    @Override
    public List<HistoryDTO> getLessonHistory(Long lessonId) {
        List<HistoryDTO> result = new ArrayList<>();
        LOGGER.info("수업별 예약이력");
        historyRepo.findAllByLessonId(lessonId).forEach(e ->{
            result.add(e.toDTO());
        });
        return result;
    }
}
