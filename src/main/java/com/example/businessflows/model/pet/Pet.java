package com.example.businessflows.model.pet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class Pet {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    private String status;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Category category;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }
    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
