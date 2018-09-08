package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CarUsers;

@Repository
public interface CarUsersRepository extends JpaRepository<CarUsers, Long> {
    CarUsers findByEmail(String email);

	CarUsers findByFirstName(String firstName);

	CarUsers findById(Long id);

}
