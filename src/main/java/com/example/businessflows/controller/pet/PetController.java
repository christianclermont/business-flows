package com.example.businessflows.controller.pet;

import com.example.businessflows.model.pet.Pet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pet")
@Validated
public class PetController {

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable @Min(1) Long petId) {
        // Dummy implementation
        Pet pet = new Pet();
        pet.setId(petId);
        pet.setName("Doggie");
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> findPetsByStatus(@RequestParam @Size(min = 1) List<String> status) {
        // Dummy implementation
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/findByTags")
    public ResponseEntity<List<Pet>> findPetsByTags(@RequestParam @Size(min = 1) List<String> tags) {
        // Dummy implementation
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet) {
        // Dummy implementation
        pet.setId(123L);
        return ResponseEntity.ok(pet);
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@Valid @RequestBody Pet pet) {
        // Dummy implementation
        return ResponseEntity.ok(pet);
    }
}
