package com.example.project1.domain.repo;
import com.example.project1.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Long>{
}
