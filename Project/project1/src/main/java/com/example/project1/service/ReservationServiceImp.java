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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
    public void reservate(String email, String pointName, String subjectName, int number, LocalDateTime date) {
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
        if(reservationRepo.findByParentIdAndSubjectId(parent.getId(),subject.getId()) != null)
            return;

        if(subject != null && (subject.getCurrentNum()+number <= subject.getMaxNum())) {
            Date rDate = java.sql.Timestamp.valueOf(date);
            Calendar c = Calendar.getInstance();
            c.setTime(rDate);
            c.add(Calendar.DATE, 14);
            rDate = c.getTime();
            Date now = new Date();
            if(rDate.before(now)) {
                subject.setCurrentNum(subject.getCurrentNum()+number);
                subjectRepo.save(subject);
                Reservation r = Reservation.ReservationBuilder().reserved(new Date()).parent(parent).subject(subject).build();
                reservationRepo.save(r);
            }
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
            Reservation reservation = reservationRepo.findByParentIdAndSubjectId(parent.getId(),subjectId);

            if(reservation != null){
                reservationRepo.delete(reservation);
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
            result.add(reservationRepo.findByParentIdAndSubjectId(point.getId(),s.getId()));
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
