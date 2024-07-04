package com.example.IncidentManager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IncidentManager.Entity.Incident;
import com.example.IncidentManager.repository.IncidentRepository;

@Service
public class IncidentService {
	@Autowired
	private IncidentRepository incidentRepository;
	
	public Incident saveIncident(Incident incident) {
		return incidentRepository.save(incident);
	}
	
	public Incident findIncidentId(int id) {
		Optional<Incident> incident = incidentRepository.findById(id);
		if(incident.isEmpty()) {
			throw new RuntimeException("Incident not Found");
		}
		return incident.get();
	}
	
	public List<Incident> findAll(){
		return incidentRepository.findAll();
	}

}
