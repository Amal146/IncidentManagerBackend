package com.example.IncidentManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IncidentManager.Entity.Incident;
import com.example.IncidentManager.repository.IncidentRepository;

@Service
public class IncidentService {
	@Autowired
	private IncidentRepository incidentRepository;
	
	//Post Incident
	public Incident saveIncident(Incident incident) {
		return incidentRepository.save(incident);
	}
	
	//Get Incident By Id
	public Incident findIncidentId(int id) {
		Optional<Incident> incident = incidentRepository.findById(id);
		if(incident.isEmpty()) {
			throw new RuntimeException("Incident not Found");
		}
		return incident.get();
	}
	
	//Get all Incident 
	public List<Incident> findAll(){
		return incidentRepository.findAll();
	}
	
	
	//Update Incident By Id
	public Incident updateIncident(Incident incident) {
		Optional<Incident> dbIncident = incidentRepository.findById(incident.getId());
		if(dbIncident.isEmpty()) {
			throw new RuntimeException("Incident not Found");
		}
		
		Incident existingIncident = dbIncident.get();	
		existingIncident.setTitle(incident.getTitle());
		existingIncident.setDescription(incident.getDescription());
		existingIncident.setReported_at(incident.getReported_at());
		existingIncident.setReported_by(incident.getReported_by());
		existingIncident.setResolved_at(incident.getResolved_at());
		existingIncident.setResolved_by(incident.getResolved_by());
		existingIncident.setSeverity(incident.getSeverity());
		existingIncident.setSolution_description(incident.getSolution_description());
		existingIncident.setStatus(incident.getStatus());
		
		return incidentRepository.save(existingIncident);
		
	}
	
	//Delete Incident By Id
	public void deleteIncident(int id) {
		Optional<Incident> dbIncident = incidentRepository.findById(id);
		if(dbIncident.isEmpty()) {
			throw new RuntimeException("Incident not Found");
		}
		
		Incident existingIncident = dbIncident.get();	
		incidentRepository.delete(existingIncident);
	}
	

}
