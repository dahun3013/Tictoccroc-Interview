package com.example.project1.service;

import com.example.project1.data.domain.LessonEntity;
import com.example.project1.data.domain.ParentEntity;
import com.example.project1.data.dto.HistoryDTO;
import com.example.project1.data.dto.LessonDTO;
import com.example.project1.data.dto.ParentDTO;
import com.example.project1.data.dto.ReservationDTO;
import com.example.project1.common.error.CustomException;
import com.example.project1.data.domain.HistoryEntity;
import com.example.project1.data.domain.repo.*;
import com.example.project1.data.mapper.HistoryMapper;
import com.example.project1.data.mapper.LessonMapper;
import com.example.project1.data.mapper.ParentMapper;
import com.example.project1.data.mapper.ReservationMapper;
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
        if(reservationRepo.existsByParentAndLesson(ParentMapper.INSTANCE.toEntity(pdto),LessonMapper.INSTANCE.toEntity(ldto))){
            throw new CustomException(DUPLICATE_RESOURCE);
        }

            
        LOGGER.info("???????????? ????????? ??????");
        LOGGER.info("????????????");
        LOGGER.info("{}", reservationDTO);

        Date rDate = reservationDTO.getDate();
        Date nowDay = TimeHelper.getInstance().changeDayOnly(new Date(), 1);
        Date maxDay = TimeHelper.getInstance().changeDayOnly(new Date(), 14);

        LOGGER.debug("???????????? ??????");
        if (!(rDate.after(nowDay) && rDate.before(maxDay))) {
            throw new CustomException(WRONG_DATE_DATA);
        }

        int number = reservationDTO.getNumber() + ldto.getCurrentNum();
        LOGGER.debug("???????????? ??????");
        if (number > ldto.getMaxNum()) {
            throw new CustomException(OVERFLOW_DATA);
        }

        LOGGER.info("{} ?????? ????????????",ldto.getLessonName());
        ldto.setCurrentNum(number);
        lessonRepo.save(LessonMapper.INSTANCE.toEntity(ldto));

        LOGGER.info("???????????? ??????");
        reservationRepo.save(ReservationMapper.INSTANCE.toEntity(reservationDTO));

        LOGGER.info("???????????? ??????");
        historyRepo.save(
                HistoryEntity.builder()
                        .date(TimeHelper.getInstance().setTimeZone(new Date()))
                        .parent(ParentMapper.INSTANCE.toEntity(pdto))
                        .lesson(LessonMapper.INSTANCE.toEntity(ldto))
                        .activity("????????????")
                        .build()
        );
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
        if(!reservationRepo.existsByParentAndLesson(ParentMapper.INSTANCE.toEntity(pdto),LessonMapper.INSTANCE.toEntity(ldto))){
            throw new CustomException(NO_DATA);
        }

        LOGGER.info("???????????? ????????? ??????");
        LOGGER.info("????????????");
        LOGGER.info("{}", reservationDTO);

        LOGGER.info("{} ?????? ????????????",ldto.getLessonName());
        ldto.setCurrentNum(ldto.getCurrentNum()-reservationDTO.getNumber());
        lessonRepo.save(LessonMapper.INSTANCE.toEntity(ldto));

        LOGGER.info("????????????");
        reservationRepo.delete(
                reservationRepo.findByParentAndLesson(ParentMapper.INSTANCE.toEntity(pdto),LessonMapper.INSTANCE.toEntity(ldto))
        );
        LOGGER.info("???????????? ??????");
        historyRepo.save(
                HistoryEntity.builder()
                        .date(TimeHelper.getInstance().setTimeZone(new Date()))
                        .parent(ParentMapper.INSTANCE.toEntity(pdto))
                        .lesson(LessonMapper.INSTANCE.toEntity(ldto))
                        .activity("????????????")
                        .build()
        );
    }

    @Override
    public List<ReservationDTO> getIslandSubscriber(Long islandId) {
        List<ReservationDTO> result = new ArrayList<>();
        LOGGER.info("????????? ????????????");
        lessonRepo.findAllByIsland(
                islandRepo.findById(islandId).get()
        ).forEach(l -> {
            reservationRepo.findAllByLesson(l)
                    .forEach(e -> {
                        result.add(ReservationMapper.INSTANCE.toDTO(e));
                    });
        });

        return result;
    }

    @Override
    public List<ReservationDTO> getLessonSubscriber(Long lessonId) {
        List<ReservationDTO> result = new ArrayList<>();
        LOGGER.info("????????? ????????????");
        reservationRepo.findAllByLesson(
                lessonRepo.findById(lessonId).get()
        ).forEach(e -> result.add(ReservationMapper.INSTANCE.toDTO(e)));

        return result;
    }

    @Override
    public List<HistoryDTO> getIslandHistory(Long islandId) {
        List<HistoryDTO> result = new ArrayList<>();
        LOGGER.info("????????? ????????????");
        lessonRepo.findAllByIsland(islandRepo.findById(islandId).get()).forEach(l ->{
            historyRepo.findAllByLesson(l).forEach(e ->{
                result.add(HistoryMapper.INSTANCE.toDTO(e));
            });
        });
        return result;
    }

    @Override
    public List<HistoryDTO> getLessonHistory(Long lessonId) {
        List<HistoryDTO> result = new ArrayList<>();
        LOGGER.info("????????? ????????????");
        historyRepo.findAllByLesson(lessonRepo.findById(lessonId).get()).forEach(e ->{
            result.add(HistoryMapper.INSTANCE.toDTO(e));
        });
        return result;
    }
}
