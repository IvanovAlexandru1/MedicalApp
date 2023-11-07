package com.example.proiectpos.dto;

import com.example.proiectpos.utils.SpecializationEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PhysicianDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doctor;
    private Integer id_user;
    private String nume;
    private String prenume;
    @Column(unique = true)
    private String email;
    private String telefon;
    private SpecializationEnum specialization;
    @OneToMany(mappedBy = "physicians")
    private Set<PhysiciansPatientsMapping> programare;
    public PhysicianDTO(Integer id_user, String nume, String prenume, String email, String telefon, SpecializationEnum specializationEnum) {
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.specialization = specializationEnum;
    }
}
