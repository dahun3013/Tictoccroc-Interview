package com.example.project1.service;

import com.example.project1.domain.Parent;
import com.example.project1.domain.Point;
import com.example.project1.domain.Reservation;
import com.example.project1.domain.Subject;
import com.example.project1.domain.repo.ParentRepo;
import com.example.project1.domain.repo.PointRepo;
import com.example.project1.domain.repo.ReservationRepo;
import com.example.project1.domain.repo.SubjectRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReservationServiceImp implements ReservationService{
    private final ParentRepo parentRepo;
    private final PointRepo pointRepo;
    private final ReservationRepo reservationRepo;
    private final SubjectRepo subjectRepo;

    @Override
    public void reservate(String email, String pointName, String subjectName, int number) {
        Parent parent = parentRepo.findByEmail(email);
        Point point = pointRepo.findByName(pointName);
        List<Subject> subjects = subjectRepo.findAllByName(subjectName);
        Subject subject = null;
        for (Subject s : subjects ){
            if(s.getPoint().getId() == point.getId()) {
                subject = s;
                break;
            }
        }
        if(subject != null) {
            Reservation r = Reservation.ReservationBuilder().reserved(new Date()).parent(parent).subject(subject).build();
            reservationRepo.save(r);
        }
    }

    @Override
    public void cancle(String email, String pointName, String subjectName) {
        Parent parent = parentRepo.findByEmail(email);
        Point point = pointRepo.findByName(pointName);
        List<Subject> subject = subjectRepo.findAllByName(subjectName);
        Long subjectId = 0L;
        for (Subject s : subject ){
            if(s.getPoint().getId() == point.getId()) {
                subjectId = s.getId();
                break;
            }
        }
        if(subjectId != 0L){
            List<Reservation> reservation = reservationRepo.findAllByParentIdAndSubjectId(parent.getId(),subjectId);

            if(reservation.size()>0){
                for (Reservation r : reservation ){
                    if(r.getSubject().getPoint().getId() == point.getId()) {
                        reservationRepo.delete(r);
                        break;
                    }
                }
            }
        }
    }

    //로직 재정립 필요
    @Override
    public List<Reservation> searchForPoint(String name) {
        List<Reservation> result = new ArrayList<>();
        Point point = pointRepo.findByName(name);
        List<Subject> subjects = subjectRepo.findAllByPointId(point.getId());
        for (Subject s : subjects) {
            result.addAll(reservationRepo.findAllByParentIdAndSubjectId(point.getId(),s.getId()));
        }
        return result;
    }

    //로직 재정립 필요
    @Override
    public List<Reservation> searchForSubject(String name) {
        List<Reservation> result = reservationRepo.findAll();
        return result;
    }
}
