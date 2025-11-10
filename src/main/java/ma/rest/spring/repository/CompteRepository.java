package ma.rest.spring.repository;

import ma.rest.spring.entity.Compte;
import ma.rest.spring.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

    //  Recherche personnalisée par type de compte
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") TypeCompte type);
}