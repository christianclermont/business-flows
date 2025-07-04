package com.bezkoder.spring.restapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.bezkoder.spring.restapi.model.Tutorial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tutorial API", description = "CRUD operations for Tutorials")
public interface ITutorialController {

    @Operation(summary = "Get all tutorials", description = "Returns a list of all tutorials, optionally filtered by title.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found tutorials"),
        @ApiResponse(responseCode = "204", description = "No tutorials found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<Tutorial>> getAllTutorials(
        @Parameter(description = "Title to filter tutorials") @RequestParam(required = false) String title);

    @Operation(summary = "Get tutorial by ID", description = "Returns a single tutorial by its ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tutorial found"),
        @ApiResponse(responseCode = "404", description = "Tutorial not found")
    })
    ResponseEntity<Tutorial> getTutorialById(@Parameter(description = "ID of the tutorial") @PathVariable("id") long id);

    @Operation(summary = "Create a new tutorial", description = "Creates a new tutorial with the provided data.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Tutorial created"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Tutorial> createTutorial(@Parameter(description = "Tutorial object to create") @RequestBody Tutorial tutorial);

    @Operation(summary = "Update a tutorial", description = "Updates an existing tutorial by its ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tutorial updated"),
        @ApiResponse(responseCode = "404", description = "Tutorial not found")
    })
    ResponseEntity<Tutorial> updateTutorial(
        @Parameter(description = "ID of the tutorial to update") @PathVariable("id") long id,
        @Parameter(description = "Updated tutorial object") @RequestBody Tutorial tutorial);

    @Operation(summary = "Delete a tutorial", description = "Deletes a tutorial by its ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Tutorial deleted"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> deleteTutorial(@Parameter(description = "ID of the tutorial to delete") @PathVariable("id") long id);

    @Operation(summary = "Delete all tutorials", description = "Deletes all tutorials.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "All tutorials deleted"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> deleteAllTutorials();

    @Operation(summary = "Find published tutorials", description = "Returns all tutorials that are published.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found published tutorials"),
        @ApiResponse(responseCode = "204", description = "No published tutorials found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<Tutorial>> findByPublished();
}
