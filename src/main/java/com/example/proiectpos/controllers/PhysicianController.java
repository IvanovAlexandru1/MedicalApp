package com.example.proiectpos.controllers;

import com.example.proiectpos.dto.PatientDTO;
import com.example.proiectpos.dto.PhysicianDTO;
import com.example.proiectpos.repositories.PhysicianRepository;
import com.example.proiectpos.utils.SpecializationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/medical_office/physicians")
public class PhysicianController {
    @Autowired
    private PhysicianRepository physicianRepository;

    public PhysicianController(PhysicianRepository physicianRepository) {
        this.physicianRepository = physicianRepository;
    }
    @GetMapping
    public ResponseEntity<List<PhysicianDTO>> getAllPhysicians(){
        return new ResponseEntity<>(physicianRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PhysicianDTO> getPatientById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(physicianRepository.findById(id).orElse(null),HttpStatus.OK);
    }
    @PostMapping("/addPhysician")
    public ResponseEntity<String> addPhysician(){

        physicianRepository.save(new PhysicianDTO(1,"Cosmin","Resmerita",
                "cosmin.resmerita@gmail.com","074324324", SpecializationEnum.Cardiologist));

        return new ResponseEntity<>("Physician added",HttpStatus.CREATED);
    }


}
