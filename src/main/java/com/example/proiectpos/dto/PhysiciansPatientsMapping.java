package com.example.proiectpos.dto;

import com.example.proiectpos.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="physician_patient")
public class PhysiciansPatientsMapping {
    @ManyToOne
    @JoinColumn(name = "physician_id")
    private PhysicianDTO physician;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientDTO patient;

    private Date date;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
