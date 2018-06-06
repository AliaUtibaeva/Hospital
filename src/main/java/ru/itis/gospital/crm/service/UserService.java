package ru.itis.gospital.crm.service;

import ru.itis.gospital.crm.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
