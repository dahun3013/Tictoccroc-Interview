package com.example.project1.data.domain.repo;

import com.example.project1.data.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
}
