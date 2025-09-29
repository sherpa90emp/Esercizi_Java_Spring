package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //rende la classe un componente gestito da spring (vengono creati bean e messi nel contesto)
public class Persona {
    private String nome = "Mario";
    //@Autowired // annotation che serve a spring per prendere un bean dal contesto e assegnarlo a questa proprietà
    private Pappagallino pappagallino;

    @Autowired // annotation che serve a spring per prendere un bean dal contesto e assegnarlo  al costruttore (sarà il più utilizzato)
    public Persona(Pappagallino pappagallino) {
        this.pappagallino = pappagallino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pappagallino getPappagallino() {
        return pappagallino;
    }

    public void setPappagallino(Pappagallino pappagallino) {
        this.pappagallino = pappagallino;
    }

    @Override
    public String toString() {
        return "< Persona di nome: " + nome + " > che ha un " + pappagallino;
    }
}