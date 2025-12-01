package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.Officer;
import com.policedb.police_force_db.repository.OfficerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin(origins = "*")
public class OfficerController {

    private final OfficerRepository officerRepository;

    public OfficerController(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    @GetMapping
    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    @PostMapping
    public Officer createOfficer(@RequestBody Officer officer) {
        return officerRepository.save(officer);
    }
}
