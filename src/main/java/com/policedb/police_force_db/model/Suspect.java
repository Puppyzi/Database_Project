package com.policedb.police_force_db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "suspects")
public class Suspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suspectId;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String address;

    @ManyToOne
    @JoinColumn(name = "case_id")
    @JsonIgnoreProperties({"suspects"})
    private PoliceCase policeCase;

    // --- Constructors ---
    public Suspect() {
    }

    public Suspect(String firstName, String lastName, LocalDate dob, String address, PoliceCase policeCase) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.policeCase = policeCase;
    }

    // --- Getters and Setters ---
    public Long getSuspectId() {
        return suspectId;
    }

    public void setSuspectId(Long suspectId) {
        this.suspectId = suspectId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PoliceCase getPoliceCase() {
        return policeCase;
    }

    public void setPoliceCase(PoliceCase policeCase) {
        this.policeCase = policeCase;
    }
}
