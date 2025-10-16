package com.example.demo_spring_jdbc_transaction.service;

import com.example.demo_spring_jdbc_transaction.model.entity.Conto;
import com.example.demo_spring_jdbc_transaction.repository.ContoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BonificoService {
    private final ContoRepository contoRepository;

    @Autowired
    public  BonificoService(ContoRepository contoRepository) {
        this.contoRepository = contoRepository;
    }

    //metodo che effettua un bonifico tra mittente e beneficiario.
    // (TODO controllare che esistano i conti)
    // Recupera conti di mittente e beneficiario;
    // TODO (controllare se ci sono fondi) calcolare il nuovo saldo;
    // Aggiornare il saldo di entrambi
    @Transactional //crfea un contesto transazionale
    public void effettuaBonifico(int idMittente, int idBeneficiario, BigDecimal ammontare) {
        Conto mittente = contoRepository.getContoById(idMittente);
        Conto beneficiario = contoRepository.getContoById(idBeneficiario);

        BigDecimal nuovoSaldoMittente = mittente.getSaldo().subtract(ammontare);
        BigDecimal nuovoSaldoBeneficiario = beneficiario.getSaldo().add(ammontare);

        contoRepository.aggiornaSaldo(idMittente, nuovoSaldoMittente);
        contoRepository.aggiornaSaldo(idBeneficiario,nuovoSaldoBeneficiario);
    }

    public List<Conto> getAllConti() {
        return contoRepository.getAllConti();
    }
}
