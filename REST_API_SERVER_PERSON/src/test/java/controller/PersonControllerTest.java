package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.makarov.ChatServerApp;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for PersonController.
 * GET      all persons.
 * GET      person by id.
 * POST     create new person.
 * PUT      update person by id.
 * DELETE   person by id.
 */
@SpringBootTest(classes = ChatServerApp.class)
@AutoConfigureMockMvc
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shoulcChelkGetAllPersons() throws Exception {
        this.mockMvc.perform(get("/person/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shoulcChelkGetPersonById() throws Exception {
        String json = this.mockMvc.perform(get("/person/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertEquals(json,"{\"id\":1,\"login\":\"Rustymattok\",\"password\":\"123\"}",true);
    }

    @Test
    public void shoulcChelkPostPerson() throws Exception {
        this.mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"login\":\"ban\",\"password\":\"123\"}"))
                .andExpect(status().isCreated());
    }
}