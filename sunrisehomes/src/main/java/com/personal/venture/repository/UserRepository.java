package com.personal.venture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.venture.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
