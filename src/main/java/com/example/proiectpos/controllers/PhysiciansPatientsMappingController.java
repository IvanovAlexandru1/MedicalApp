package com.example.proiectpos.controllers;

import com.example.proiectpos.repositories.PhysiciansPatientsMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/medical_office")
public class PhysiciansPatientsMappingController {
    @Autowired
    private PhysiciansPatientsMappingRepository physiciansPatientsMappingRepository;

    public PhysiciansPatientsMappingController(PhysiciansPatientsMappingRepository physiciansPatientsMappingRepository) {
        this.physiciansPatientsMappingRepository = physiciansPatientsMappingRepository;
    }

    @PostMapping("physicians/{phy_id}/patients/{pat_id}")
    public ResponseEntity<String> addPatientToPhysicianById(@PathVariable("phy_id")Integer phy_id,@PathVariable("pat_id") String pat_id){
        physiciansPatientsMappingRepository.addPatientToPhysician(phy_id,pat_id);
        return new ResponseEntity<String>("Patient added to Physician", HttpStatus.CREATED);
    }
}
