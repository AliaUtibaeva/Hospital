package ru.itis.gospital.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.gospital.crm.forms.DoctorForm;
import ru.itis.gospital.crm.models.Doctor;
import ru.itis.gospital.crm.models.Role;
import ru.itis.gospital.crm.models.User;
import ru.itis.gospital.crm.repositories.DoctorRepository;
import ru.itis.gospital.crm.repositories.UserRepository;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Transactional
    public void register(DoctorForm doctorForm) {
        User user = new User();
        Doctor doctor = new Doctor();

        user.setPasswordHash(passwordEncoder.encode(doctorForm.getPassword()));
        user.setRole(Role.DOCTOR);
        user.setLogin(doctorForm.getLogin());
        user.setDoctor(doctor);

        doctor.setFirstName(doctorForm.getFirstname());
        doctor.setLastName(doctorForm.getLastname());
        doctor.setPatronymic(doctorForm.getPatronymic());
        doctor.setBirthDate(doctorForm.getBirth_date());
        doctor.setWorkExperience(doctorForm.getWorkExperience());
        doctor.setUser(user);

        userRepository.save(user);
        doctorRepository.save(doctor);
    }

    public Doctor getDoctor(User user) throws Exception{
        Optional<Doctor> doctor = doctorRepository.findByUser(user);
        if (doctor.isPresent()) {
            return doctor.get();
        }
        else {
            throw new Exception("user not found");
        }
    }
}
