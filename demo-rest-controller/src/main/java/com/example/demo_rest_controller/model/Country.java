package com.example.demo_rest_controller.model;

public class Country {
    private String nome;
    private int population; //in milioni di abitanti

    //metodo costruttore statico, factory method
    public static Country of(String nome, int population) {
        Country country = new Country();
        country.nome = nome;
        country.population = population;
        return country;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nome='" + nome + '\'' +
                ", population=" + population +
                '}';
    }
}
