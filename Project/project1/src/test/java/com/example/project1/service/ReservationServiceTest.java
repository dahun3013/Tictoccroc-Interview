package com.example.project1.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@SpringBootTest(classes = ReservationServiceImp.class)
@ExtendWith(SpringExtension.class)
@Import(ReservationServiceImp.class)
public class ReservationServiceTest {

}
