package com.example.IncidentManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IncidentManager.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{

}
