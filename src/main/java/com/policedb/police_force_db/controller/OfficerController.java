package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.Officer;
import com.policedb.police_force_db.model.Station;
import com.policedb.police_force_db.repository.OfficerRepository;
import com.policedb.police_force_db.repository.StationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin(origins = "*")
public class OfficerController {

    private final OfficerRepository officerRepository;
    private final StationRepository stationRepository;

    public OfficerController(OfficerRepository officerRepository, StationRepository stationRepository) {
        this.officerRepository = officerRepository;
        this.stationRepository = stationRepository;
    }

    @GetMapping
    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    @PostMapping
    public Officer createOfficer(@RequestBody Officer officer) {
        officer.setStation(resolveStation(officer.getStation()));
        return officerRepository.save(officer);
    }

    @GetMapping("/{id}")
    public Officer getOfficerById(@PathVariable Long id) {
        return officerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Officer not found"));
    }

    @PutMapping("/{id}")
    public Officer updateOfficer(@PathVariable Long id, @RequestBody Officer updated) {
        Officer existing = officerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Officer not found"));

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setBadgeNumber(updated.getBadgeNumber());
        existing.setRank(updated.getRank());
        existing.setStation(resolveStation(updated.getStation()));

        return officerRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOfficer(@PathVariable Long id) {
        if (!officerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Officer not found");
        }
        officerRepository.deleteById(id);
    }

    private Station resolveStation(Station stationPayload) {
        if (stationPayload == null || stationPayload.getStationId() == null) {
            return null;
        }

        return stationRepository.findById(stationPayload.getStationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Station not found"));
    }
}
