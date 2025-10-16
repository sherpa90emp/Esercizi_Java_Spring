package com.example.demo_spring_jdbc_transaction.repository;

import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import com.example.demo_spring_jdbc_transaction.repository.mapper.ContoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ContoRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public ContoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Conto> rowMapper = new ContoRowMapper();

    //metodo che torna un account passato l'id
    public Conto getContoById(int id) {
        String sql = "SELECT * FROM conti WHERE id = ?";
        return jdbc.queryForObject(sql, rowMapper, id);
    }

    //metodo che torna tutti i conti
    public List<Conto> getAllConti() {
        String sql = "SELECT * FROM conti";
        return jdbc.query(sql, rowMapper);
    }

    //metodo che permette di modificare il saldo dell'account passato il suo id
    public void aggiornaSaldo(int id, BigDecimal nuovoSaldo) {
        String sql = "UPDATE conti SET saldo = ? WHERE id = ?";
        jdbc.update(sql, nuovoSaldo, id); //si fornisce prima il nuovo saldo perche è il primo parametro della stringa sql
    }
}
