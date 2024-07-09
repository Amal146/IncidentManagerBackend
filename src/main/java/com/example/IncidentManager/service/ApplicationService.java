package com.example.IncidentManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IncidentManager.Entity.Application;
import com.example.IncidentManager.repository.ApplicationRepository;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	// POST Application
	public Application saveApplication(Application application) {
		return applicationRepository.save(application);
	}
	
	// GET Application by id 
	public Application findApplicationById(int id) {
		Optional<Application> application = applicationRepository.findById(id);
		if (application.isEmpty()) {
			throw new RuntimeException("Application not found") ;
		}
		return application.get();	
	}
	
	
	// GET All Applications
	public List<Application> findAll(){
		return applicationRepository.findAll();
	}
	
	// UPDATE existing Application
	public Application updateApplication(int id, Application updatedApplication) {
        Optional<Application> existingAppOpt = applicationRepository.findById(id);
        if (existingAppOpt.isEmpty()) {
            throw new RuntimeException("Application not found with id: " + id);
        }

        Application existingApp = existingAppOpt.get();

        // Update fields only if they are not null in the updatedApplication object
        if (updatedApplication.getName() != null) {
            existingApp.setName(updatedApplication.getName());
        }

        // Save and return the updated application
        return applicationRepository.save(existingApp);
    }
	
	// DELETE existing application
	public void deleteApplication(int id) {
		Optional<Application> existingApp = applicationRepository.findById(id);
		if (existingApp.isEmpty()) {
			throw new RuntimeException("Application not found") ;
		}
		applicationRepository.delete(existingApp.get());
		
	}
}
