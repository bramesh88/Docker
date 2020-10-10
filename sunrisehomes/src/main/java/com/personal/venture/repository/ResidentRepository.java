package com.personal.venture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.venture.bean.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
}
