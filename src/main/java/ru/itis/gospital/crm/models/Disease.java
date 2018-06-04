package ru.itis.gospital.crm.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 14.04.2018
 * Disease
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
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icdName;

    @ElementCollection
    private List<String> symptoms;
}
