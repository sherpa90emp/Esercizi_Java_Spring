package com.example.demo_jdbc_tutorial.repository;

import com.example.demo_jdbc_tutorial.model.Tutorial;

import java.util.List;

public interface TutorialRepository {
    //Create
    int save(Tutorial tutorial);
    //Update
    int update(Tutorial tutorial);
    //Delete
    int deleteById(Long id);
    int deleteAll();
    //Read
    Tutorial findById(Long id);

    List<Tutorial> findAll();

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByCategory(String category);

    List<Tutorial> findByTitleContaining(String title);
}
