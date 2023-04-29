package com.pti.workforce.restControllers;

import com.pti.workforce.entities.Workshop;
import com.pti.workforce.repositories.WorkshopRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/workshop")
    public Workshop postWorkshop(final @RequestBody Workshop workshop) {
        return workshopRepository.save(workshop);
    }
}
