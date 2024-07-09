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
	
	// Post Incident
	public Incident saveIncident(Incident incident) {


	    List<Incident> dbIncident = incidentRepository.findByDescription(incident.getDescription());
	    if (dbIncident.isEmpty()) {
	        return incidentRepository.save(incident);
	    }

	    throw new RuntimeException("Incident already exists");
	}


	// GET Contributors By Incident
	public List<Object[]> findContributorsByIncident(int applicationId) {      
        return incidentRepository.findContributorsByIncident(applicationId);
    }
	
	
	//Get Incident By Id
	public Incident findIncidentId(int id) {
		Optional<Incident> incident = incidentRepository.findById(id);
		if(incident.isEmpty()) {
			throw new RuntimeException("Incident not Found");
		}
		return incident.get();
	}
	
	// Get Incident By Title
    public List<Incident> findIncidentByTitle(String title) {
        return incidentRepository.findByTitle(title);
    }
	
    // Get Incident By Application Id
    public Incident findIncidentByAppId(int applicationId) {
        return incidentRepository.findByApplicationId(applicationId);
    }
    
    
	//Get all Incident 
	public List<Incident> findAll(){
		return incidentRepository.findAll();
	}
	
	
	// Update Incident By Id
	public Incident updateIncident(int id, Incident incident) {
	    Optional<Incident> dbIncident = incidentRepository.findById(id);
	    if (dbIncident.isEmpty()) {
	        throw new RuntimeException("Incident not Found");
	    }
	    
	    Incident existingIncident = dbIncident.get();
	    
	    existingIncident.setTitle(incident.getTitle());
	    existingIncident.setDescription(incident.getDescription());
	    existingIncident.setReportedAt(incident.getReportedAt());
	    existingIncident.setResolvedAt(incident.getResolvedAt());
	    existingIncident.setSolutionDescription(incident.getSolutionDescription());
	    existingIncident.setStatus(incident.getStatus());
	    existingIncident.setSeverity(incident.getSeverity());
	    
	   
	   
	    
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
