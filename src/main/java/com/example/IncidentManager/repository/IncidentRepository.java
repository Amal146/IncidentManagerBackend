package com.example.IncidentManager.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.IncidentManager.Entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>{
    List<Incident> findByTitle(String title);
    List<Incident> findByDescription(String description);
    Incident findByApplicationId(int applicationId);
    @Query(value = "SELECT id, reporter_id, resolver_id FROM public.incident WHERE application_id = ?1", nativeQuery = true)
    List<Object[]> findContributorsByIncident(int applicationId);
}
