package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.PoliceCase;
import com.policedb.police_force_db.repository.PoliceCaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@CrossOrigin(origins = "*")
public class PoliceCaseController {

    private final PoliceCaseRepository policeCaseRepository;

    public PoliceCaseController(PoliceCaseRepository policeCaseRepository) {
        this.policeCaseRepository = policeCaseRepository;
    }

    @GetMapping
    public List<PoliceCase> getAllCases() {
        return policeCaseRepository.findAll();
    }

    @PostMapping
    public PoliceCase createCase(@RequestBody PoliceCase policeCase) {
        return policeCaseRepository.save(policeCase);
    }
}
