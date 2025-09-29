package config;

import domain.Gatto;
import domain.Pappagallino;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("domain")
public class ProjectConfig {
    @Bean
    public Pappagallino pappagallino1() {
        Pappagallino p = new Pappagallino();
        p.setNome("Koko");
        return p;
    }

    @Bean
    @Scope("prototype") //al contrario di singleton, ogni volta che è richiesto un bean viene creata una nuova istanza
    @Lazy //l'istanza/e viene creata solo quando è consumata dal client (non all'inizio, solo quando è usata)
    public Gatto gatto() {
        return new Gatto();
    }
}
