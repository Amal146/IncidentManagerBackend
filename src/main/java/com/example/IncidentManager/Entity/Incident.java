package com.example.IncidentManager.Entity;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Id;

@Entity
@Table(name = "incidents")
@Getter
@Setter
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String application;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Enumerated(EnumType.STRING)
    private SeverityType severity;

    private Timestamp reported_at;
    private Timestamp resolved_at;

    private String reported_by;
    private String resolved_by;
    private String solution_description;

    public enum StatusType {
        Open, In_Progress, Resolved, Closed
    }

    public enum SeverityType {
        Low, Medium, High, Critical
    }

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

    public StatusType getStatus() {
        return status;
    }

    @Transient
    public void setStatus(String status) {
        this.status = status != null ? StatusType.valueOf(status) : null;
    }
    
    public void setStatus(StatusType status) {
        this.status = status;
    }

    public SeverityType getSeverity() {
        return severity;
    }

    @Transient
    public void setSeverity(String severity) {
        this.severity = severity != null ? SeverityType.valueOf(severity) : null;
    }
    
    public void setSeverity(SeverityType severity) {
        this.severity = severity;
    }

    public Timestamp getReported_at() {
        return reported_at;
    }

    public void setReported_at(Timestamp reported_at) {
        this.reported_at = reported_at;
    }

    public Timestamp getResolved_at() {
        return resolved_at;
    }

    public void setResolved_at(Timestamp resolved_at) {
        this.resolved_at = resolved_at;
    }

    public String getReported_by() {
        return reported_by;
    }

    public void setReported_by(String reported_by) {
        this.reported_by = reported_by;
    }

    public String getResolved_by() {
        return resolved_by;
    }

    public void setResolved_by(String resolved_by) {
        this.resolved_by = resolved_by;
    }

    public String getSolution_description() {
        return solution_description;
    }

    public void setSolution_description(String solution_description) {
        this.solution_description = solution_description;
    }

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}
}
