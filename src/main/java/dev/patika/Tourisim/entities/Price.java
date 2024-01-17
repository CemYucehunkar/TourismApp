package dev.patika.Tourisim.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "price")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double price;

    private int adultPrice;

    private int childPrice;

    @ManyToOne
    private Season season;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Lodging lodging;
}
