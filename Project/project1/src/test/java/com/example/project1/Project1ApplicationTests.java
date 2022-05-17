package com.example.project1;

import com.example.project1.domain.repo.ParentRepo;
import com.example.project1.domain.repo.IslandRepo;
import com.example.project1.domain.repo.ReservationRepo;
import com.example.project1.domain.repo.LessonRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project1ApplicationTests {
    @Autowired
    ParentRepo parentRepo;
    @Autowired
    IslandRepo islandRepo;
    @Autowired
    LessonRepo lessonRepo;
    @Autowired
    ReservationRepo reservationRepo;

    @Test
    void contextLoads() {
    }
    @Test
    public void testClass(){
        System.out.println(parentRepo.getClass().getName());
    }
    @Test
    public void testInsertDummies(){
        /*
        IntStream.rangeClosed(1,100).forEach(i->{
            Parent p = Parent.ParentBuilder().name("이름 "+i).email("hi@naver.com").build();
            parentRepo.save(p);
        });
        */
        /*
        IntStream.rangeClosed(1,4).forEach(i->{
            Point p = Point.PointBuilder().name(i+"번 지점").address(i+"번 주소").build();
            pointRepo.save(p);
        });*/

        //Subject s = Subject.SubjectBuilder().name("드로잉").point(pointRepo.findByName("1번 지점")).currentNum(0).maxNum(20).build();
        //subjectRepo.save(s);
        //Subject s = subjectRepo.findByName("드로잉");
        //System.out.println(p + ", "+s);
        //Reservation r = Reservation.ReservationBuilder().parent(p).subject(s).build();
        //reservationRepo.save(r);
    }

    @Test
    public void testUpdate(){
        //Parent p = Parent.ParentBuilder().id(1L).name("바꾸고싶다").email("바꾸고싶다").build();
        //System.out.println(parentRepo.save(p));
    }
}
