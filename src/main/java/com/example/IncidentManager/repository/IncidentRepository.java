package com.example.IncidentManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IncidentManager.Entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>{
    Optional<Incident> findByTitle(String title);

}
