package ru.itis.gospital.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gospital.crm.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
