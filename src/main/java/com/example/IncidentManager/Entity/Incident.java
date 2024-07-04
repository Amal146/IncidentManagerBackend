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
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public Time getReported_at() {
		return reported_at;
	}
	public void setReported_at(Time reported_at) {
		this.reported_at = reported_at;
	}
	public Time getResolved_at() {
		return resolved_at;
	}
	public void setResolved_at(Time resolved_at) {
		this.resolved_at = resolved_at;
	}
	public Time getReported_by() {
		return reported_by;
	}
	public void setReported_by(Time reported_by) {
		this.reported_by = reported_by;
	}
	public Time getResolved_by() {
		return resolved_by;
	}
	public void setResolved_by(Time resolved_by) {
		this.resolved_by = resolved_by;
	}
	public String getSolution_description() {
		return solution_description;
	}
	public void setSolution_description(String solution_description) {
		this.solution_description = solution_description;
	}

	
}