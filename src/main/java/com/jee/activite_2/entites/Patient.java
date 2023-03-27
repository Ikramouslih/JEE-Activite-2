package com.jee.activite_2.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity // JPA entity : This class correspond to a Table in the DB
@Data @NoArgsConstructor @AllArgsConstructor //Lombok Annotations : implicitly adding getters & setters, Constructor with and without parameters
public class Patient {

    @Id //Id of the entity : This attribute is the id of the entity and the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id generated automatically
    private Long id;
    @Column(length = 50) //Max length of this string is 50 characters
    private String nom;
    @Temporal(TemporalType.DATE) //Using the date only, without the time
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
