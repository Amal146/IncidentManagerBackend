package com.example.IncidentManager.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IncidentManager.Entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>{
    List<Incident> findByTitle(String title);
    Incident findByApplicationId(int applicationId);
}
