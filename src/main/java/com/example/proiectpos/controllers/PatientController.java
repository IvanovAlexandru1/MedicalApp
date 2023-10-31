package com.example.proiectpos.controllers;

import com.example.proiectpos.dto.PatientDTO;
import com.example.proiectpos.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    public PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return new ResponseEntity<>(patientRepository.getAllPatients(), HttpStatus.OK);
    }


}
