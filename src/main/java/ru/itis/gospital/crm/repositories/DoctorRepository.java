package ru.itis.gospital.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gospital.crm.models.Doctor;
import ru.itis.gospital.crm.models.User;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUser(User user);
}
