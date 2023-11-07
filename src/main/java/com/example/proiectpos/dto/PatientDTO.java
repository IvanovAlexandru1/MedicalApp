package com.example.proiectpos.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientDTO {
    @Id
    private String cnp;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private String nume;
    private String prenume;
    @Column(unique = true)
    private String email;
    private String telefon;
    private Date data_nasterii;
    private boolean is_active;
    @ManyToMany(mappedBy = "patients")
    private Set<PhysicianDTO> physicians;
    public PatientDTO(String cnp, Integer id_user, String nume, String prenume, String email, String telefon, Date data_nasterii, boolean is_active) {
        this.cnp = cnp;
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.data_nasterii = data_nasterii;
        this.is_active = is_active;
    }
}
