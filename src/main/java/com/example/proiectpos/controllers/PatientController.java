package com.example.proiectpos.controllers;

import com.example.proiectpos.dto.PatientDTO;
import com.example.proiectpos.hateoas.PatientHateoas;
import com.example.proiectpos.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/medical_office/patients")
public class PatientController {
    private final PatientRepository patientRepository;
    private final PatientHateoas patientHateoas;
    @Autowired
    public PatientController(PatientRepository patientRepository,PatientHateoas patientHateoas) {
        this.patientRepository = patientRepository;
        this.patientHateoas = patientHateoas;
    }
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<PatientDTO>>> getAllPatients(){
        return new ResponseEntity<>(patientHateoas.toCollectionModel(patientRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PatientDTO>> getPatientById(@PathVariable("id") String id){
        PatientDTO patientDTO = patientRepository.findById(id).orElse(null);
        return new ResponseEntity<>(patientHateoas.toModel(patientDTO),HttpStatus.OK);
    }
    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(){
        Date today = new Date();
        PatientDTO patientDTO = new PatientDTO("032100213",1,"Ivanov","Alexandru","alexandruivanov@gmail.com"
                ,"0742343223",today,true);
        patientRepository.save(patientDTO);
        return new ResponseEntity<>("Patient added", HttpStatus.CREATED);
    }
}
