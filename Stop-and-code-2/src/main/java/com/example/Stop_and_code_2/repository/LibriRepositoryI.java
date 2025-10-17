package com.example.Stop_and_code_2.repository;

import com.example.Stop_and_code_2.model.entity.Libro;

import java.util.List;

public interface LibriRepositoryI {
    List<Libro> getAllBooks();

    Libro getBookById(Long id);

    int saveBook(Libro libro);

    void updateBook(Libro libro);

    int deleteBookById(Long id);
}
