package com.example.IncidentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IncidentManager.Entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer>{


}
