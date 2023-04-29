package com.pti.workforce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class WorkshopTest {

    @Test
    public void testConstructNewWorkshop() {
        Workshop workshop = new Workshop();
        workshop.setId(1);
        assertEquals(1, workshop.getId());
    }

}