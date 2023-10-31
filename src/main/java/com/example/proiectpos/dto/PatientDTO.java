package com.example.proiectpos.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PatientDTO {
    private String cnp;
    private int id_user;
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private Date data_nasterii;
    private boolean is_active;
}
