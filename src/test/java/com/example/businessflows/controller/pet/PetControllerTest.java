package com.example.businessflows.controller.pet;

import com.example.businessflows.model.pet.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PetController.class)
class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getPetById_validId_returnsPet() throws Exception {
        mockMvc.perform(get("/api/pet/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void getPetById_invalidId_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/pet/0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void findPetsByStatus_valid_returnsOk() throws Exception {
        mockMvc.perform(get("/api/pet/findByStatus")
                        .param("status", "available"))
                .andExpect(status().isOk());
    }

    @Test
    void findPetsByStatus_empty_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/pet/findByStatus"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void findPetsByTags_valid_returnsOk() throws Exception {
        mockMvc.perform(get("/api/pet/findByTags")
                        .param("tags", "cute"))
                .andExpect(status().isOk());
    }

    @Test
    void findPetsByTags_empty_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/pet/findByTags"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addPet_valid_returnsOk() throws Exception {
        Pet pet = new Pet();
        pet.setName("Doggie");
        String json = objectMapper.writeValueAsString(pet);
        mockMvc.perform(post("/api/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void addPet_invalid_returnsBadRequest() throws Exception {
        Pet pet = new Pet();
        String json = objectMapper.writeValueAsString(pet);
        mockMvc.perform(post("/api/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updatePet_valid_returnsOk() throws Exception {
        Pet pet = new Pet();
        pet.setName("Doggie");
        String json = objectMapper.writeValueAsString(pet);
        mockMvc.perform(put("/api/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void updatePet_invalid_returnsBadRequest() throws Exception {
        Pet pet = new Pet();
        String json = objectMapper.writeValueAsString(pet);
        mockMvc.perform(put("/api/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }
}
