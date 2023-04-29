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

    @Test
    public void testSetWorkshopTitle() {
        Workshop workshop = new Workshop();
        workshop.setTitle("This Workshop");
        assertEquals("This Workshop", workshop.getTitle());
    }

    @Test
    public void testSetWorkshopInformation() {
        Workshop workshop = new Workshop();
        String info = "This is the info for the workshop that is important";
        workshop.setDetails(info);
        assertEquals(info, workshop.getDetails());

    }
}