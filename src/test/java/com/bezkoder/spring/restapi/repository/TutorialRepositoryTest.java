package com.bezkoder.spring.restapi.repository;

import com.bezkoder.spring.restapi.model.TutorialEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TutorialRepositoryTest {
    @Autowired
    private TutorialRepository tutorialRepository;

    @AfterEach
    void tearDown() {
        tutorialRepository.deleteAll();
    }

    @Test
    void testSaveAndFindById() {
        TutorialEntity entity = new TutorialEntity("TestTitle", "TestDesc", true);
        TutorialEntity saved = tutorialRepository.save(entity);
        assertNotNull(saved.getId());
        assertTrue(tutorialRepository.findById(saved.getId()).isPresent());
    }

    @Test
    void testFindByTitleContaining() {
        tutorialRepository.save(new TutorialEntity("Java Spring", "desc", false));
        tutorialRepository.save(new TutorialEntity("Spring Boot", "desc", true));
        List<TutorialEntity> found = tutorialRepository.findByTitleContaining("Spring");
        assertEquals(2, found.size());
    }

    @Test
    void testFindByPublished() {
        tutorialRepository.save(new TutorialEntity("T1", "desc", false));
        tutorialRepository.save(new TutorialEntity("T2", "desc", true));
        List<TutorialEntity> published = tutorialRepository.findByPublished(true);
        assertEquals(1, published.size());
        assertTrue(published.get(0).isPublished());
    }

    @Test
    void testDeleteById() {
        TutorialEntity entity = tutorialRepository.save(new TutorialEntity("T", "desc", false));
        tutorialRepository.deleteById(entity.getId());
        assertFalse(tutorialRepository.findById(entity.getId()).isPresent());
    }
}
