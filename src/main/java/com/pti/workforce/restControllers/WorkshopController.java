package com.pti.workforce.restControllers;

import com.pti.workforce.repositories.WorkshopRepository;

public class WorkshopController {

    final private WorkshopRepository workshopRepository;

    public WorkshopController(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }
}
