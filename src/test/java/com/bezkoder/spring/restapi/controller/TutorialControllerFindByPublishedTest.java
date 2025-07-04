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
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TutorialController.class)
class TutorialControllerFindByPublishedTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorialService tutorialService;

    @BeforeEach
    void setUp() {
        Mockito.when(tutorialService.findByPublished(true)).thenReturn(Collections.emptyList());
    }

    @Test
    void findByPublished_ReturnsNoContent() throws Exception {
        mockMvc.perform(get("/api/tutorials/published"))
                .andExpect(status().isNoContent());
    }
}
