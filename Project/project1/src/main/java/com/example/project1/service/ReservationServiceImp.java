package com.example.project1.service;

import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.Parent;
import com.example.project1.domain.Reservation;
import com.example.project1.domain.Leasson;
import com.example.project1.domain.repo.ParentRepo;
import com.example.project1.domain.repo.IslandRepo;
import com.example.project1.domain.repo.ReservationRepo;
import com.example.project1.domain.repo.LeassonRepo;
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
    private final LeassonRepo leassonRepo;

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
            Optional<Parent> p = parentRepo.findById(reservation.getParent().getParentId());
            Optional<Leasson> l = leassonRepo.findById(reservation.getLeasson().getLeassonId());
            int number = reservation.getNumber() + l.get().getCurrentNum();

            if(number<=l.get().getMaxNum()){
                l.get().setCurrentNum(number);
                leassonRepo.save(l.get());

                reservationRepo.save(
                        Reservation.ReservationBuilder().
                                reserved(rDate).
                                parent(p.get()).
                                leasson(l.get()).
                                build()
                );
            }
        }
    }

    @Override
    public void cancleReservation(ReservationDTO reservation) {
        Parent p = reservation.getParent();
        Leasson l = reservation.getLeasson();
        reservationRepo.delete(
                reservationRepo.findByParentIdAndLeassonId(p.getParentId(),l.getLeassonId())
        );
    }

    @Override
    public List<Reservation> getParentsSubscriber(Long parentId){
        return reservationRepo.findAllByParentId(parentId);
    }

    @Override
    public List<Reservation> getIslandSubscriber(Long islandId) {
        return reservationRepo.findAllByIslandId(islandId);
    }

    @Override
    public List<Reservation> getLeassonSubscriber(Long leassonId) {
        return reservationRepo.findAllByLeassonId(leassonId);
    }
}
