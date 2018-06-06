package ru.itis.gospital.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.gospital.crm.models.Client;
import ru.itis.gospital.crm.forms.ClientForm;

import ru.itis.gospital.crm.models.Role;
import ru.itis.gospital.crm.models.User;

import ru.itis.gospital.crm.repositories.ClientRepository;
import ru.itis.gospital.crm.repositories.UserRepository;

import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void register(ClientForm clientForm) {
        User user = User.builder()
                .login(clientForm.getLogin())
                .passwordHash(passwordEncoder.encode(clientForm.getPassword()))
                .role(Role.CLIENT)
                .build();
        Client client = Client.builder()
                .lastName(clientForm.getLastname())
                .firstName(clientForm.getFirstname())
                .patronymic(clientForm.getPatronymic())
                .birthDate(clientForm.getBirth_date())
                .phone(clientForm.getPhone())
                .build();
        user.setClient(client);

        userRepository.save(user);
        client.setUser(user);
        clientRepository.save(client);
    }

    public Client getClient(User user) throws Exception{
        Optional<Client> client = clientRepository.findByUser(user);
        if (client.isPresent()) {
            return client.get();
        }
        else {
            throw new Exception("user not found");
        }
    }


}
