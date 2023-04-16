package com.jee.activite_2;

import com.jee.activite_2.entites.Patient;
import com.jee.activite_2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
//If a class implements the Interface CommandLineRunner, it should redefine the run() methode
public class Activite2Application implements CommandLineRunner {

    @Autowired //Dependency Injection : Spring looks for an implementation of this interface and injects it into this object
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Activite2Application.class, args);
    }

    //The run() method is used to run instructions automatically when the application first starts
    //This method requires the implementation of the interface CommandLineRunner
    @Override
    public void run(String... args) throws Exception {

    //Experimenting with Spring Data's default methods

        //Creating and saving entities into the DB
        patientRepository.save(new Patient(null, "Ikram",new Date(),true, 40));
        patientRepository.save(new Patient(null, "Khadija",new Date(),false, 100));
        patientRepository.save(new Patient(null, "Mohamed",new Date(),false, 90));

        //Getting the list of patients from the DB
       List<Patient> patients =  patientRepository.findAll();

       System.out.println("The initial list of patients : ");
       //Printing the patients' info
       patients.forEach(p->{
           System.out.println("-------------------");
           System.out.println(p.getId());
           System.out.println(p.getNom());
           System.out.println(p.getDateNaissance());
           System.out.println(p.isMalade());
           System.out.println(p.getScore());
       });

        //Getting a patient by Id and printing his/her info
        Patient patient = patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient Not Found."));
        System.out.println("The patient with the id N° 1 : ");
        System.out.println("********* Before Update *********");
        if(patient != null)
        {
            System.out.println("Patient N° " + patient.getId() + " : " + patient.getNom());
            System.out.println("Date of birth : " + patient.getDateNaissance());
            System.out.println("Sick : " + patient.isMalade());
            System.out.println("Score : " + patient.getScore());
        }

        //Modifying the score for this patient
        patient.setScore(870);
        //The method save inserts into the DB if the id is null, but updates if the id has a value
        patientRepository.save(patient);
        //Printing the patient's info after updating his/her scores
        if(patient != null)
        {
            System.out.println("********* After Update *********");

            System.out.println("Patient N° " + patient.getId() + " : " + patient.getNom());
            System.out.println("Date of birth : " + patient.getDateNaissance());
            System.out.println("Sick : " + patient.isMalade());
            System.out.println("Score : " + patient.getScore());
        }

        //Delete all patients
        patientRepository.deleteAll();

        System.out.println("********* List with pagination *********");

    //Pagination

        //Creating 100 patients
        for(int i = 0 ; i < 100 ; i++)
        {
            patientRepository.save(
                    new Patient(null, "patient"+i, new Date(), Math.random()>0.5?true:false, (int)(Math.random()*100)));
        }

        //Getting the first page of the patients list, with 5 patients
        Page<Patient> patientsPage =  patientRepository.findAll(PageRequest.of(1,5));

        //Total number of pages
        System.out.println("Total number of pages : " + patientsPage.getTotalPages());
        //Total number of elements
        System.out.println("Total number of patients : " + patientsPage.getTotalElements());
        //Printing the page number
        System.out.println("Page Number : " + patientsPage.getNumber());

        //Getting the list of patients from the page
        List<Patient> content =  patientsPage.getContent();

        //Printing the patients' info from the page
        content.forEach(p->{
            System.out.println("-------------------");
            System.out.println("Patient N° " + p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println("Sick : " +p.isMalade());
            System.out.println("Score : "+p.getScore());
        });

        System.out.println("********* Using custom Spring data methods : findByMalade() *********");
        System.out.println("********* List of patients who are sick *********");

    //Using our custom function that we defined by its name in PatientRepository
        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,4));
        System.out.println("Page Number : " + byMalade.getNumber());
        byMalade.forEach(m->{
            System.out.println("-------------------");
            System.out.println("Patient N° " + m.getId());
            System.out.println(m.getNom());
            System.out.println(m.getDateNaissance());
            System.out.println("Sick : " +m.isMalade());
            System.out.println("Score : "+m.getScore());
        });

    //Using our custom function that we defined by an HQL request in PatientRepository

        List<Patient> patientList = patientRepository.chercherPatients2("%1%", 40);
        System.out.println("********* Testing a custom HQL method : chercherPatients2() *********");
        System.out.println("List of patients who have the character \"1\" in their name and have a lesser score than 40 :");
        patientList.forEach(m->{
            System.out.println(m.getId());
            System.out.println(m.getNom());
            System.out.println(m.getDateNaissance());
            System.out.println(m.isMalade());
            System.out.println(m.getScore());
            System.out.println("-------------------");

        });

        System.out.println("End of app.");
    }
}
