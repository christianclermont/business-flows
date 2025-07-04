package com.bezkoder.spring.restapi.service;

import com.bezkoder.spring.restapi.model.TutorialEntity;
import com.bezkoder.spring.restapi.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;

    public List<TutorialEntity> findAll() {
        return tutorialRepository.findAll();
    }

    public List<TutorialEntity> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    public TutorialEntity findById(long id) {
        Optional<TutorialEntity> result = tutorialRepository.findById(id);
        return result.orElse(null);
    }

    public TutorialEntity save(TutorialEntity tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void deleteById(long id) {
        tutorialRepository.deleteById(id);
    }

    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    public List<TutorialEntity> findByPublished(boolean isPublished) {
        return tutorialRepository.findByPublished(isPublished);
    }
}
