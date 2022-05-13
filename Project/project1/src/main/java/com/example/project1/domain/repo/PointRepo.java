package com.example.project1.domain.repo;
import com.example.project1.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepo extends JpaRepository<Point, Long> {
    Point findByName(String name);
}
