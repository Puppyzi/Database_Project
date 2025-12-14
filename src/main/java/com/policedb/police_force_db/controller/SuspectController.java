package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.PoliceCase;
import com.policedb.police_force_db.model.Suspect;
import com.policedb.police_force_db.repository.PoliceCaseRepository;
import com.policedb.police_force_db.repository.SuspectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/suspects")
@CrossOrigin(origins = "*")
public class SuspectController {

    private final SuspectRepository suspectRepository;
    private final PoliceCaseRepository policeCaseRepository;

    public SuspectController(SuspectRepository suspectRepository, PoliceCaseRepository policeCaseRepository) {
        this.suspectRepository = suspectRepository;
        this.policeCaseRepository = policeCaseRepository;
    }

    @GetMapping
    public List<Suspect> getAllSuspects() {
        return suspectRepository.findAll();
    }

    @PostMapping
    public Suspect createSuspect(@RequestBody Suspect suspect) {
        suspect.setPoliceCase(resolveCase(suspect.getPoliceCase()));
        return suspectRepository.save(suspect);
    }

    @GetMapping("/{id}")
    public Suspect getSuspectById(@PathVariable Long id) {
        return suspectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Suspect not found"));
    }

    @PutMapping("/{id}")
    public Suspect updateSuspect(@PathVariable Long id, @RequestBody Suspect updated) {
        Suspect existing = suspectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Suspect not found"));

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setDob(updated.getDob());
        existing.setAddress(updated.getAddress());
        existing.setPoliceCase(resolveCase(updated.getPoliceCase()));

        return suspectRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSuspect(@PathVariable Long id) {
        if (!suspectRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suspect not found");
        }
        suspectRepository.deleteById(id);
    }

    private PoliceCase resolveCase(PoliceCase casePayload) {
        if (casePayload == null || casePayload.getCaseId() == null) {
            return null;
        }

        return policeCaseRepository.findById(casePayload.getCaseId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case not found"));
    }
}
