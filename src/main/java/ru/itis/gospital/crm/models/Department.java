package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 14.04.2018
 * Department
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "chief_id")
    private User chief;

    @OneToOne
    @JoinColumn(name = "cabinet_id")
    private Cabinet cabinet;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors;
}

