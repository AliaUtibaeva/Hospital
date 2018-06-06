package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "gospital_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column(length = 1000)
    private String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Client client;

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
}
