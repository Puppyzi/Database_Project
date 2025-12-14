package com.policedb.police_force_db.controller;

import com.policedb.police_force_db.model.Officer;
import com.policedb.police_force_db.model.PoliceCase;
import com.policedb.police_force_db.repository.OfficerRepository;
import com.policedb.police_force_db.repository.PoliceCaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@CrossOrigin(origins = "*")
public class PoliceCaseController {

    private final PoliceCaseRepository policeCaseRepository;
    private final OfficerRepository officerRepository;

    public PoliceCaseController(PoliceCaseRepository policeCaseRepository, OfficerRepository officerRepository) {
        this.policeCaseRepository = policeCaseRepository;
        this.officerRepository = officerRepository;
    }

    @GetMapping
    public List<PoliceCase> getAllCases() {
        return policeCaseRepository.findAll();
    }

    @PostMapping
    public PoliceCase createCase(@RequestBody PoliceCase policeCase) {
        policeCase.setLeadOfficer(resolveLeadOfficer(policeCase.getLeadOfficer()));
        return policeCaseRepository.save(policeCase);
    }

    @GetMapping("/{id}")
    public PoliceCase getCaseById(@PathVariable Long id) {
        return policeCaseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case not found"));
    }

    @PutMapping("/{id}")
    public PoliceCase updateCase(@PathVariable Long id, @RequestBody PoliceCase updated) {
        PoliceCase existing = policeCaseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case not found"));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setDateOpened(updated.getDateOpened());
        existing.setDateClosed(updated.getDateClosed());
        existing.setLeadOfficer(resolveLeadOfficer(updated.getLeadOfficer()));

        return policeCaseRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCase(@PathVariable Long id) {
        if (!policeCaseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Case not found");
        }
        policeCaseRepository.deleteById(id);
    }

    private Officer resolveLeadOfficer(Officer officerPayload) {
        if (officerPayload == null || officerPayload.getOfficerId() == null) {
            return null;
        }

        return officerRepository.findById(officerPayload.getOfficerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead officer not found"));
    }
}
