package com.example.IncidentManager.Entity;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "incidents")
@Getter
@Setter
public class Incident  {
	@Id
	private Integer id; 
	private String title ;
	private String description ;
	private String status ;
	private String severity;
	private Time reported_at;
	private Time resolved_at;
	private Time reported_by;
	private Time resolved_by;
	private String solution_description;

	
}