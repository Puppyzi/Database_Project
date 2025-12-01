package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.Suspect;
import com.policedb.police_force_db.repository.SuspectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suspects")
@CrossOrigin(origins = "*")
public class SuspectController {

    private final SuspectRepository suspectRepository;

    public SuspectController(SuspectRepository suspectRepository) {
        this.suspectRepository = suspectRepository;
    }

    @GetMapping
    public List<Suspect> getAllSuspects() {
        return suspectRepository.findAll();
    }

    @PostMapping
    public Suspect createSuspect(@RequestBody Suspect suspect) {
        return suspectRepository.save(suspect);
    }
}
