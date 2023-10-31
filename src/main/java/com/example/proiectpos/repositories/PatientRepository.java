package com.example.proiectpos.repositories;

import com.example.proiectpos.dto.PatientDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository {
    public List<PatientDTO> patientDTOList = new ArrayList<>();

    public List<PatientDTO> getAllPatients(){
        return patientDTOList;
    }

    public PatientDTO findPatientById(int id){

        Optional<PatientDTO> patient = patientDTOList.stream()
                .filter(x -> x.getId_user() == id).findFirst();
        return patient.orElse(null);
    }

    public void addPatient(PatientDTO patientDTO){
        patientDTOList.add(patientDTO);
    }

    public void deletePatientById(int id){

        Optional<PatientDTO> patient = patientDTOList.stream()
                .filter(x -> x.getId_user() == id).findFirst();

        patientDTOList.remove(patient.orElse(null));
    }

}
