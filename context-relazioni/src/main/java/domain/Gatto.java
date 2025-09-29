package domain;

import java.util.UUID;

public class Gatto {

    private String nome = "Pino";
    private final String id;

    public Gatto() {
        //ogni gatto che viene creato con una new ha un id diverso dagli altri gatti creati
        this.id = UUID.randomUUID().toString();
        System.out.println("Gatto creato con id: " + id);
    }

    @Override
    public String toString() {
        return "Gatto{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
