package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 14.04.2018
 * Station
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    private Integer number;

    @OneToMany(mappedBy = "station")
    private List<User> clients;
}
