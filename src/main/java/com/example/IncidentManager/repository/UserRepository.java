package com.example.IncidentManager.repository;
import com.example.IncidentManager.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);
}