package com.example.Stop_and_code_2.controller;

import com.example.Stop_and_code_2.model.entity.Libro;
import com.example.Stop_and_code_2.repository.LibriRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/libri")
public class LibriController {
    private final LibriRepositoryI libriRepositoryI;

    @Autowired
    public LibriController(LibriRepositoryI libriRepositoryI) {
        this.libriRepositoryI = libriRepositoryI;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAllBooks() {
        List<Libro> libri = new ArrayList<>(libriRepositoryI.getAllBooks());
        if (libri.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(libri);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getBookById(@PathVariable Long id) throws EmptyResultDataAccessException {
        try {
            Libro libro = libriRepositoryI.getBookById(id);
            if (libro == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(libro);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> saveBook(@RequestBody Libro libro) {
        int valoreR = libriRepositoryI.saveBook(libro);
        if (valoreR == 1) return ResponseEntity.ok("Libro salvato!");
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Libro libro) throws EmptyResultDataAccessException{
        try {
            Libro _libro = libriRepositoryI.getBookById(id);
            if (_libro == null) return ResponseEntity.notFound().build();
            _libro.setTitolo(libro.getTitolo());
            _libro.setAutore(libro.getAutore());
            _libro.setPubblicazione(libro.getPubblicazione());
            libriRepositoryI.updateBook(_libro);
            return ResponseEntity.ok("Libro aggiornato!");
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) throws EmptyResultDataAccessException{
        try {
            int valoreR = libriRepositoryI.deleteBookById(id);
            if (valoreR == 0) return ResponseEntity.badRequest().build();
            return ResponseEntity.ok("Libro con id " + id + " eliminato!");
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.notFound().build();
        }

    }
}
