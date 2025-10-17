package com.example.Stop_and_code_2.repository;

import com.example.Stop_and_code_2.model.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibriRepository implements LibriRepositoryI{
    private final JdbcTemplate jdbc;

    @Autowired
    public LibriRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Libro> getAllBooks() {
        String sql = "SELECT * FROM libri";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Libro.class));
    }

    @Override
    public Libro getBookById(Long id) {
        String sql = "SELECT * FROM libri WHERE id = ?";
        return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(Libro.class),
                id
        );
    }

    @Override
    public int saveBook(Libro libro) {
        String sql = "INSERT INTO libri (titolo, autore, pubblicazione) VALUES (?, ?, ?)";
        return jdbc.update(sql,
                libro.getTitolo(),
                libro.getAutore(),
                libro.getPubblicazione()
        );
    }

    @Override
    public void updateBook(Libro libro) {
        String sql = "UPDATE libri SET titolo = ?, autore = ?, pubblicazione = ? WHERE id = ?";
        jdbc.update(sql,
                libro.getTitolo(),
                libro.getAutore(),
                libro.getPubblicazione(),
                libro.getId()
        );
    }

    @Override
    public int deleteBookById(Long id) {
        String sql = "DELETE FROM libri WHERE id = ?";
        return jdbc.update(sql, id);
    }
}
