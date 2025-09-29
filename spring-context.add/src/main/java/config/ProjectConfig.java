package config;

import domain.Pappagallino;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // stabilisce che la classe è una configurazione di Spring
@ComponentScan("domain") // indico alla config il package dove risiedono i componenti da caricare
public class ProjectConfig {
    @Bean//definisce un bean di nome (in questo caso) pappagallino1 ecc.
    Pappagallino pappagallino1() {
        var p = new Pappagallino();
        p.setNome("Gino");
        return p;
    }

    @Bean
    @Primary //stabilisce che il bean è quello di default
    Pappagallino pappagallino2() {
        var p = new Pappagallino();
        p.setNome("Riccardo");
        return p;
    }

    @Bean(name = "pappagallinoLuca") //stabilisce un bean con nome personalizzato
    Pappagallino pappagallino3() {
        var p = new Pappagallino();
        p.setNome("Luca");
        return p;
    }
}
