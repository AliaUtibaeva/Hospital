package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 14.04.2018
 * Complaint
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
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    private String text;

    private LocalDateTime dateTime;
}
