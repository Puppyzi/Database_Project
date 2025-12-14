package com.policedb.police_force_db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "officers")
@JsonIgnoreProperties({"casesLed"})
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officerId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String badgeNumber;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "station_id")
    @JsonIgnoreProperties({"officers"})
    private Station station;

    @OneToMany(mappedBy = "leadOfficer")
    private List<PoliceCase> casesLed;

    // --- Constructors ---
    public Officer() {
    }

    public Officer(String firstName, String lastName, String badgeNumber, String rank, Station station) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.station = station;
    }

    // --- Getters and Setters ---

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
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

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<PoliceCase> getCasesLed() {
        return casesLed;
    }

    public void setCasesLed(List<PoliceCase> casesLed) {
        this.casesLed = casesLed;
    }
}
