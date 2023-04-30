package com.pti.workforce.restControllers;

import com.pti.workforce.entities.Workshop;
import com.pti.workforce.repositories.WorkshopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@CrossOrigin
public class WorkshopController {

    final private WorkshopRepository workshopRepository;

    public WorkshopController(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    @GetMapping("/api/workshops")
    public Iterable<Workshop> getWorkshops() {
        return workshopRepository.findAll();
    }

    @GetMapping("/api/workshop/{workshop_id}")
    public Workshop getWorkshopById(final @PathVariable long workshop_id) {
        final Optional<Workshop> perhapsWorkshop = workshopRepository.findById(workshop_id);
        return perhapsWorkshop.orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find workshop" + workshop_id));
    }

    @PostMapping("/api/workshop")
    public Workshop postWorkshop(final @RequestBody Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    @DeleteMapping("/api/workshop/{workshop_id}")
    public void deleteWorkshop(@PathVariable final long workshop_id) {
        final Workshop workshop = workshopRepository.findById(workshop_id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot delete nonexistent workshop" + workshop_id));

        workshopRepository.delete(workshop);
    }
}
