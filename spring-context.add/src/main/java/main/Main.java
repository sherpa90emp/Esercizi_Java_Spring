package main;

import config.ProjectConfig;
import domain.Pappagallino;
import domain.Persona;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //vuole avere una istanza di pappagallino senza doverselo creare
        // quindi lo chiediamo al context di Spring

        //recupera l'oggetto context passandogli la configurazione che abbiamo creato
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //recupera un bean dal context (generico, se presenti più di uno è quello con annotation @Primary)
        Pappagallino mioPappagallino = context.getBean(Pappagallino.class);
        System.out.printf("Recuperato dal context = %s\n", mioPappagallino);

        // recupero tramite il nome del metodo @Bean
        Pappagallino pappagallino1 = context.getBean("pappagallino1", Pappagallino.class);
        System.out.printf("Recuper dal context tramite nome del metodo bean = %s\n", pappagallino1);

        //recupero tramite il nome personalizzato sul metodo @Bean
        Pappagallino pappagallino3 = context.getBean("pappagallinoLuca", Pappagallino.class);
        System.out.printf("Recuperato dal context tramite nome personalizzato = %s\n", pappagallino3);

        //recupero un bean annotato con component
        Persona persona = context.getBean(Persona.class);
        System.out.printf("Recuperato dal context un bean annotato con component = %s\n", persona);

        //*** registro un nuovo bean nel context a runtime (programmaticamente)
        //creo una nuovo istanza
        Pappagallino p = new Pappagallino();
        p.setNome("Koko");
        //creo un oggetto/funzione che restituisce l'istanza appena creata
        Supplier<Pappagallino> pappagallinoSupplier = () -> p;
        //chiedo al context di aggiungere il mio bean
        context.registerBean("koko", Pappagallino.class, pappagallinoSupplier);

        //recupero il nuovo bean dal context
        Pappagallino koko = context.getBean("koko", Pappagallino.class);
        System.out.printf("Recuperato dal context dopo inserimento programmatico = %s\n", koko);
    }
}
