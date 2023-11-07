package com.example.proiectpos.repositories;

import com.example.proiectpos.dto.PatientDTO;
import com.example.proiectpos.dto.PhysicianDTO;
import com.example.proiectpos.dto.PhysiciansPatientsMapping;
import com.example.proiectpos.utils.StatusEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public class PhysiciansPatientsMappingRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;

    public PhysiciansPatientsMappingRepository(PhysicianRepository physicianRepository, PatientRepository patientRepository) {
        this.physicianRepository = physicianRepository;
        this.patientRepository = patientRepository;
    }
    @Transactional
    public void addPatientToPhysician(Integer physician_id, String patient_id){

        Optional<PhysicianDTO> physicianDTO = physicianRepository.findById(physician_id);
        Optional<PatientDTO> patientDTO = patientRepository.findById(patient_id);

        PhysiciansPatientsMapping physiciansPatientsMapping = new PhysiciansPatientsMapping(physicianDTO.orElse(null)
                ,patientDTO.orElse(null), new Date(), StatusEnum.Neprezentat);
        entityManager.persist(physiciansPatientsMapping);
    }
}
