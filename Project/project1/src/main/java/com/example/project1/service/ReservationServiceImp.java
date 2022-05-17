package com.example.project1.service;

import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.Parent;
import com.example.project1.domain.Reservation;
import com.example.project1.domain.Lesson;
import com.example.project1.domain.repo.ParentRepo;
import com.example.project1.domain.repo.IslandRepo;
import com.example.project1.domain.repo.ReservationRepo;
import com.example.project1.domain.repo.LessonRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public void makeReservation(ReservationDTO reservation) {
        Date rDate = reservation.getReserved();
        Date nowDay = new Date();
        Date maxDay = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(nowDay);
        c.add(Calendar.DATE, 1);
        nowDay = c.getTime();
        c.setTime(maxDay);
        c.add(Calendar.DATE, 14);
        maxDay = c.getTime();

        if(nowDay.after(rDate) && maxDay.before(rDate)) {
            Optional<Parent> p = parentRepo.findById(reservation.getParent().getId());
            Optional<Lesson> l = lessonRepo.findById(reservation.getLesson().getId());
            int number = reservation.getNumber() + l.get().getCurrentNum();

            if(number<=l.get().getMaxNum()){
                l.get().setCurrentNum(number);
                lessonRepo.save(l.get());

                reservationRepo.save(
                        Reservation.ReservationBuilder().
                                reserved(rDate).
                                parent(p.get()).
                                lesson(l.get()).
                                build()
                );
            }
        }
    }

    @Override
    public void cancelReservation(ReservationDTO reservation) {
        Parent p = reservation.getParent();
        Lesson l = reservation.getLesson();
        reservationRepo.delete(
                reservationRepo.findByParentIdAndLessonId(p.getId(),l.getId())
        );
    }

    @Override
    public List<Reservation> getParentsSubscriber(Long parentId){
        return reservationRepo.findAllByParentId(parentRepo.findById(parentId).get().getId());
    }

    @Override
    public List<Reservation> getIslandSubscriber(Long islandId) {
        List<Reservation> result = new ArrayList<>();
        lessonRepo.findAllByIslandId(
                islandRepo.findById(islandId).get().getId()
        ).forEach(l -> {result.addAll(reservationRepo.findAllByLessonId(l.getId()));});

        return result;
    }

    @Override
    public List<Reservation> getLessonSubscriber(Long lessonId) {
        return reservationRepo.findAllByLessonId(lessonRepo.findById(lessonId).get().getId());
    }
}
