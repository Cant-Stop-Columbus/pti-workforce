package com.pti.workforce.restControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pti.workforce.entities.Workshop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // reset the database for each test
@AutoConfigureMockMvc
class WorkshopControllerTest {

    @Autowired
    private MockMvc mvc;

    //Helper function to turn an object into JSON content
    private static String getJsonContent(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Test
    public void workshopControllerTest() throws Exception {

        //set up a new workshop instance
        final String newTitle = "This is the title of the workshop";
        final String newDetails = "This is the details of the workshop";
        final Workshop workshop = new Workshop(newTitle, newDetails);

        //Return an empty array of workshops
        mvc.perform(MockMvcRequestBuilders.get("/api/workshops").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));

        //Post a new workshop to the database
        mvc.perform(MockMvcRequestBuilders.post("/api/workshop")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(workshop)))
                .andExpect(status().isOk());
    }
}