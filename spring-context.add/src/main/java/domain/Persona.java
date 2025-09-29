package domain;

import org.springframework.stereotype.Component;

@Component //rende la classe un componente gestito da spring (vengono creati bean e messi nel contesto)
public class Persona {
    private String nome = "Mario";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "< Persona di nome: " + nome + " >";
    }
}
