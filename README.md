# JEE-Activite-2

Le but de cette activité est de se familiariser avec un projet Spring boot en implémentant une entité JPA « Patient » et les opérations CRUD pour la manipuler, tout en utilisant la technique ORM ou le Mapping relationnel objet.

### Présentation du Spring Boot ###  
Spring Boot est un framework open source pour le développement d'applications Java. Il fournit un cadre prêt à l'emploi pour créer des applications et des services Web en utilisant la configuration plutôt qu'une approche programmatique. 
Spring Boot aide à créer des applications qui ne sont pas liées à une plate-forme spécifique et qui peuvent s'exécuter localement sur un appareil sans connexion Internet ou autres services installés pour être fonctionnelles.

### La configuration du projet ### 
- SDK : 1.8 Oracle OpenJDK version 18.0.2
- Java : 17
- Type : Maven 
=> Un projet Maven est un projet logiciel qui utilise l'outil de gestion de projet Maven pour automatiser la construction, la documentation et les dépendances du projet. Maven fournit un ensemble de conventions de configuration standard pour les projets Java, ainsi qu'une structure de projet organisée en modules.
- Packaging : Jar 
=>Les fichiers JAR nous permettent de regrouper plusieurs fichiers afin de les utiliser comme bibliothèque, plug-in ou tout type d'application.
Lorsqu'un projet Maven est construit avec un package de "jar", Maven compilera le code source Java, regroupera les classes compilées et les ressources associées dans un fichier Jar, et installera ou déploiera le fichier Jar résultant dans un référentiel local ou distant pour consommation.

### Les dépendances utilisées ### 
- Lombok : Un outil de bibliothèque Java qui génère du code pour minimiser le code ‘boilerplate’. La bibliothèque remplace le code ‘boilerplate’ par des annotations faciles à utiliser (Exemples : @NoArgsConstructor, @Getter, @Setter…).
- Spring Web : pour créer des applications Web, y compris RESTful, à l'aide de Spring MVC. Utilise Apache Tomcat comme conteneur intégré par défaut.
- Spring DATA JPA : Pour conserver les données dans ‘SQL stores‘ avec Java Persistance API à l’aide de Spring Data et Hibernate. C'est un module qui facilite le ORM basé sur JPA. Il est utilisé avec les bases de données relationnelles.
- H2 Database : Une base de données intégrée, open source et en mémoire. C'est un système de gestion de base de données relationnelle écrit en Java. C'est une application client/serveur et elle est généralement utilisée dans les tests unitaires.
- MySQL : MySQL est l'un des systèmes de bases de données relationnelles les plus populaires et il est souvent utilisé dans les applications Spring Boot.


