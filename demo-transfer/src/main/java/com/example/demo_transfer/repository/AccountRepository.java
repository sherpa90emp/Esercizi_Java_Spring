package com.example.demo_transfer.repository;

import com.example.demo_transfer.model.entity.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

//Estendendo crud repository chiediamo al framework di costruirci dei metodi di base(pronti per l'uso) per le operazioni di crude classico.
//CrudRepository<T, U> dove: T è il tipo di entity che il repo gestisce; U è il tipo dell'id (primary key) di questa entity
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE name = :name") //si evita la parte di scrivere la stringa sql e poi richiamarla nel metodo
    List<Account> findAccountsByName(String name);

    @Modifying //fa usare update a jdbc
    @Query("UPDATE account SET amount = :amount WHERE id = :id") // i ? dopo = non serve usarli si usa invece il :(parametro/i usati)
    void changeAmount(long id, BigDecimal amount);
}
