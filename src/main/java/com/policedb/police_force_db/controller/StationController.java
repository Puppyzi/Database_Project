package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.Station;
import com.policedb.police_force_db.repository.StationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "*")
public class StationController {

    private final StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @GetMapping
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @PostMapping
    public Station createStation(@RequestBody Station station) {
        return stationRepository.save(station);
    }
}
