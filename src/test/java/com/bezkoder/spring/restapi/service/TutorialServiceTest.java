package com.bezkoder.spring.restapi.service;

import com.bezkoder.spring.restapi.model.Tutorial;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TutorialServiceTest {
    TutorialService service;

    @BeforeEach
    void setUp() {
        service = new TutorialService();
        service.deleteAll();
    }

    @Test
    void testSaveAndFindAll_saveMultipleTutorials_returnsAllTutorials() {
        Tutorial t1 = new Tutorial("Title1", "Desc1", false);
        Tutorial t2 = new Tutorial("Title2", "Desc2", true);
        service.save(t1);
        service.save(t2);
        List<Tutorial> all = service.findAll();
        assertEquals(2, all.size());
    }

    @Test
    void testFindById_existingId_returnsTutorial() {
        Tutorial t = new Tutorial("Title", "Desc", false);
        Tutorial saved = service.save(t);
        Tutorial found = service.findById(saved.getId());
        assertNotNull(found);
        assertEquals(saved.getTitle(), found.getTitle());
    }

    @Test
    void testSave_updateExistingTutorial_updatesTutorial() {
        Tutorial t = new Tutorial("Title", "Desc", false);
        Tutorial saved = service.save(t);
        saved.setTitle("Updated");
        service.save(saved);
        Tutorial found = service.findById(saved.getId());
        assertEquals("Updated", found.getTitle());
    }

    @Test
    void testDeleteById_existingId_tutorialIsDeleted() {
        Tutorial t = new Tutorial("Title", "Desc", false);
        Tutorial saved = service.save(t);
        service.deleteById(saved.getId());
        assertNull(service.findById(saved.getId()));
    }

    @Test
    void testDeleteAll_multipleTutorials_allDeleted() {
        service.save(new Tutorial("T1", "D1", false));
        service.save(new Tutorial("T2", "D2", true));
        service.deleteAll();
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    void testFindByTitleContaining_partialTitle_returnsMatchingTutorials() {
        service.save(new Tutorial("Java Spring", "D1", false));
        service.save(new Tutorial("Spring Boot", "D2", true));
        List<Tutorial> found = service.findByTitleContaining("Spring");
        assertEquals(2, found.size());
    }

    @Test
    void testFindByPublished_true_returnsOnlyPublishedTutorials() {
        service.save(new Tutorial("T1", "D1", false));
        service.save(new Tutorial("T2", "D2", true));
        List<Tutorial> published = service.findByPublished(true);
        assertEquals(1, published.size());
        assertTrue(published.get(0).isPublished());
    }
}
