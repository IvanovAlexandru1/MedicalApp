package com.example.proiectpos.controllers;

import com.example.proiectpos.dto.PatientDTO;
import com.example.proiectpos.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/medical_office/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") String id){
        return new ResponseEntity<>(patientRepository.findById(id).orElse(null),HttpStatus.OK);
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
