package com.example.Stop_and_code_2.model.entity;

public class Libro {
    private long id;
    private String titolo;
    private String autore;
    private int pubblicazione;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getPubblicazione() {
        return pubblicazione;
    }

    public void setPubblicazione(int pubblicazione) {
        this.pubblicazione = pubblicazione;
    }
}
