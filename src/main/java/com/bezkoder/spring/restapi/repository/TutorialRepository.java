package com.bezkoder.spring.restapi.repository;

import com.bezkoder.spring.restapi.model.TutorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long> {
    List<TutorialEntity> findByTitleContaining(String title);
    List<TutorialEntity> findByPublished(boolean published);
}
