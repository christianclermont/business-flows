package com.bezkoder.spring.restapi.controller;

import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorialService tutorialService;

    private Tutorial tutorial1;
    private Tutorial tutorial2;

    @BeforeEach
    void setUp() {
        tutorial1 = new Tutorial("Title1", "Desc1", false);
        tutorial1.setId(1L);
        tutorial2 = new Tutorial("Title2", "Desc2", true);
        tutorial2.setId(2L);
    }

    @Test
    void getAllTutorials_ReturnsList() throws Exception {
        Mockito.when(tutorialService.findAll()).thenReturn(Arrays.asList(tutorial1, tutorial2));
        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"));
    }

    @Test
    void getAllTutorials_EmptyList() throws Exception {
        Mockito.when(tutorialService.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getTutorialById_Found() throws Exception {
        Mockito.when(tutorialService.findById(1L)).thenReturn(tutorial1);
        mockMvc.perform(get("/api/tutorials/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title1"));
    }

    @Test
    void getTutorialById_NotFound() throws Exception {
        Mockito.when(tutorialService.findById(99L)).thenReturn(null);
        mockMvc.perform(get("/api/tutorials/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createTutorial_ReturnsCreated() throws Exception {
        Tutorial toSave = new Tutorial("New", "Desc", false);
        Tutorial saved = new Tutorial("New", "Desc", false);
        saved.setId(3L);
        Mockito.when(tutorialService.save(any(Tutorial.class))).thenReturn(saved);
        mockMvc.perform(post("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New\",\"description\":\"Desc\",\"published\":false}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3L));
    }

    @Test
    void updateTutorial_Found() throws Exception {
        Tutorial updated = new Tutorial("Updated", "Desc", true);
        updated.setId(1L);
        Mockito.when(tutorialService.findById(1L)).thenReturn(tutorial1);
        Mockito.when(tutorialService.save(any(Tutorial.class))).thenReturn(updated);
        mockMvc.perform(put("/api/tutorials/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated\",\"description\":\"Desc\",\"published\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"));
    }

    @Test
    void updateTutorial_NotFound() throws Exception {
        Mockito.when(tutorialService.findById(99L)).thenReturn(null);
        mockMvc.perform(put("/api/tutorials/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated\",\"description\":\"Desc\",\"published\":true}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteTutorial_ReturnsNoContent() throws Exception {
        Mockito.doNothing().when(tutorialService).deleteById(1L);
        mockMvc.perform(delete("/api/tutorials/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteAllTutorials_ReturnsNoContent() throws Exception {
        Mockito.doNothing().when(tutorialService).deleteAll();
        mockMvc.perform(delete("/api/tutorials"))
                .andExpect(status().isNoContent());
    }
}
