package com.example.proiectpos.repositories;

import com.example.proiectpos.dto.PhysicianDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<PhysicianDTO,Integer> {
}
