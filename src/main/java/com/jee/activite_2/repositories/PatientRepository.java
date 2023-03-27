package com.jee.activite_2.repositories;

import com.jee.activite_2.entites.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//This interface is the utilisation of the module Spring data JPA : it facilitates the concept of ORM
//It provides us with the classic methods that manipulate the JPA entities
public interface PatientRepository extends JpaRepository<Patient,Long> {

    //It is possible to define methods by just naming them
    //They are implemented automatically by Spring data using the name of the method
    public List<Patient> findByMalade(boolean m);
    public Page<Patient> findByMalade(boolean m, Pageable pageable);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);

//These two next methods are equivalent : using the method's name or using an HQL request
    //Creating a method that returns a list of patients where their date of birth is between d1 and d2, are sick and their name is mc;
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2, String mc);
    //The @Query annotation makes it possible to create a method using a HQL request
    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatients1(@Param("x") Date d1, @Param("y") Date d2, @Param("z") String mc);

    //another example
    @Query("select p from Patient p where p.nom like :x and p.score < :y")
    List<Patient> chercherPatients2(@Param("x") String nom, @Param("y") int scoreMin);

}
