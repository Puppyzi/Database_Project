package com.policedb.police_force_db.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "stations")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    private String name;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "station")
    private List<Officer> officers;

    // --- Constructors ---
    public Station() {
    }

    public Station(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // --- Getters and Setters ---
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Officer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<Officer> officers) {
        this.officers = officers;
    }
}
