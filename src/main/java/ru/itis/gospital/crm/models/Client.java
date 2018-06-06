package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String phone;

    private LocalDate birthDate;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "client")
    private User user;

}
