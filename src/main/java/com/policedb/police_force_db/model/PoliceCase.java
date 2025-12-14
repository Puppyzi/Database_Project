package com.policedb.police_force_db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cases")
@JsonIgnoreProperties({"suspects"})
public class PoliceCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String title;

    @Column(length = 2000)
    private String description;

    private String status; // e.g. "OPEN", "CLOSED"

    private LocalDate dateOpened;

    private LocalDate dateClosed;

    @ManyToOne
    @JoinColumn(name = "lead_officer_id")
    @JsonIgnoreProperties({"casesLed"})
    private Officer leadOfficer;

    @OneToMany(mappedBy = "policeCase")
    private List<Suspect> suspects;

    // --- Constructors ---
    public PoliceCase() {
    }

    public PoliceCase(String title, String description, String status, LocalDate dateOpened, Officer leadOfficer) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateOpened = dateOpened;
        this.leadOfficer = leadOfficer;
    }

    // --- Getters and Setters ---
    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
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

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDate getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDate dateClosed) {
        this.dateClosed = dateClosed;
    }

    public Officer getLeadOfficer() {
        return leadOfficer;
    }

    public void setLeadOfficer(Officer leadOfficer) {
        this.leadOfficer = leadOfficer;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(List<Suspect> suspects) {
        this.suspects = suspects;
    }
}
