package ma.rest.spring;

import ma.rest.spring.entity.Client;
import ma.rest.spring.entity.Compte;
import ma.rest.spring.entity.TypeCompte;
import ma.rest.spring.repository.ClientRepository;
import ma.rest.spring.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            // Exposer les IDs dans les réponses JSON
            restConfiguration.exposeIdsFor(Compte.class, Client.class);

            // Création de deux clients
            Client c1 = clientRepository.save(new Client(null, "Amal", "amal@gmail.com", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", "ali@gmail.com", null));

            // Création de comptes pour chaque client
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            compteRepository.findAll().forEach(c -> System.out.println(c.toString()));
 };
}
}