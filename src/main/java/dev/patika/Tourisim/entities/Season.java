package dev.patika.Tourisim.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "season")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "season", cascade = CascadeType.REMOVE)
    private List<Price> seasonalPrices;
}
