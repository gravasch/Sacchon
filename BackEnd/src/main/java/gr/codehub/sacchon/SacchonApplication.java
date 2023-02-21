package gr.codehub.sacchon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SacchonApplication {

    public static void main(String[] args) {

        SpringApplication.run(SacchonApplication.class, args);
    }

}
