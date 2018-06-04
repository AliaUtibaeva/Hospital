package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;

/**
 * 14.04.2018
 * Cabinet
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
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;
}
