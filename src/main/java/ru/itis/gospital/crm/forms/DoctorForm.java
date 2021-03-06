package ru.itis.gospital.crm.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorForm {
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate birth_date;
    private String login;
    private String password;
    private int workExperience;
}
