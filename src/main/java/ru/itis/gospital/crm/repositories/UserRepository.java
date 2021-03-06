package ru.itis.gospital.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.gospital.crm.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
