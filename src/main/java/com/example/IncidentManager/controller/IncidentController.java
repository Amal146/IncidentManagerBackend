package com.example.IncidentManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.IncidentManager.Entity.Incident;
import com.example.IncidentManager.service.IncidentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(value = "Incident API", description = "CRUD operations for Incident")
public class IncidentController {
	@Autowired
	private IncidentService incidentService;
	
    @ApiOperation(value = "Add one incident", response = Incident.class)
	@PostMapping("/save")
	public Incident save(@RequestBody Incident incident) {
		return incidentService.saveIncident(incident);
	}
	
    
	@GetMapping("/findAll")
    @ApiOperation(value = "Retrieve all incidents", response = List.class)
	public List<Incident> findAll() {
		return  incidentService.findAll();
	}
	
	@GetMapping("/findById")
    @ApiOperation(value = "Retrieve one incident by id", response = Incident.class)
	public Incident findById(@RequestBody int id) {
		return incidentService.findIncidentId(id);
	}
	
	@GetMapping("/findByTitle")
	@ApiOperation(value = "Retrieve incidents by title", response = List.class)
	public List<Incident> findByTitle(@RequestParam String title) {
	     return incidentService.findIncidentByTitle(title);
	 }
	
	@GetMapping("/findByAppId")
	@ApiOperation(value = "Retrieve incidents by application id", response = Incident.class)
	public Incident findByAppId(@RequestParam int applicationId) {
	     return incidentService.findIncidentByAppId(applicationId);
	}

	
	@PutMapping("/update")
    @ApiOperation(value = "update one incident by id", response = Incident.class)
	public Incident update(@RequestBody Incident incident) {
		return incidentService.updateIncident(incident);
	}
	
	
	@DeleteMapping("/delete")
    @ApiOperation(value = "delete one incident by id")
	public void delete(@RequestBody int id) {
		incidentService.deleteIncident(id);
	}
}
