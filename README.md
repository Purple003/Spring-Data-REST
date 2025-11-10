# TP - API Bancaire REST avec Spring Boot

## Réalisé par

**Arroche Aya**

## Encadré par

**Pr. Mohamed LACHGAR**

## Module

**Architecture Microservices : Conception, Déploiement et Orchestration**

## Établissement

**École Normale Supérieure - Université Cadi Ayyad**

---
## Description
Ce projet met en place une application **Spring Boot** utilisant **Spring Data REST** pour exposer automatiquement des entités JPA sous forme d’API RESTful.  
L’objectif est de gérer des **clients** et leurs **comptes bancaires** à l’aide d’une base de données **H2 en mémoire**.

---

## Technologies et Dépendances
- Spring Boot  
- Spring Data JPA  
- Spring Data REST  
- H2 Database  
- Lombok  
- Spring Boot DevTools  

---

## ⚙️ Configuration
Fichier `application.properties` :

```properties
spring.datasource.url=jdbc:h2:mem:banque
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

server.port=8082
spring.jpa.hibernate.ddl-auto=update
spring.data.rest.base-path=/api
```
---
##  Structure Principale
### Entités :
- Compte : id, solde, dateCréation, type, client
- Client : id, nom, email, liste de comptes

## Enum :
```
public enum TypeCompte {
  COURANT, EPARGNE
}
```

### Étape 10 : Pagination et Tri

- Spring Data REST permet la pagination automatique :

- http://localhost:8082/api/comptes?page=0&size=2
- http://localhost:8082/api/comptes?page=0&size=2&sort=solde,desc

### Étape 11 : Liens Client–Compte

- Relations :

@OneToMany côté Client

@ManyToOne côté Compte

- Endpoints :

/api/clients/1/comptes → comptes d’un client

/api/comptes/1/client → client associé à un compte

### Étape 12 : Recherche par Type de Compte

/api/comptes/search/byType?t=EPARGNE

/api/comptes/search/byType?t=COURANT

### Résultats et Tests
- Des captures d’écran des étapes 10, 11 et 12 montrent :
![WhatsApp Image 2025-11-10 at 12 37 43_9d6d789f](https://github.com/user-attachments/assets/691e22b1-c380-45b6-9626-57d8a5623aef)
![WhatsApp Image 2025-11-10 at 12 36 01_3c3bc1cc](https://github.com/user-attachments/assets/d465703e-daf2-452c-a7e9-8accee27dbde)
![WhatsApp Image 2025-11-10 at 12 35 16_34ec7698](https://github.com/user-attachments/assets/97782572-a70c-49ad-a81b-b4dee5160ea0)
![WhatsApp Image 2025-11-10 at 12 34 17_f0ba1c13](https://github.com/user-attachments/assets/692fd226-0688-44bc-8bdb-761834a373e1)
![WhatsApp Image 2025-11-10 at 12 33 35_e11ceba7](https://github.com/user-attachments/assets/4a001dfa-b074-4d6f-ac85-ee963c082c41)


### Console H2
#### Accès à la base :
- http://localhost:8082/h2-console
- JDBC URL : jdbc:h2:mem:banque
- User : sa

### Exécution

- Lancer le projet avec votre IDE ou mvn spring-boot:run

- Ouvrir http://localhost:8082/api pour explorer les endpoints REST.

- Tester les requêtes avec Postman ou un navigateur.
