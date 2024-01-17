package dev.patika.Tourisim.entities;

import dev.patika.Tourisim.enums.LodgingType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lodging")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Enumerated(EnumType.STRING) // Enumları belirtirken bu şekilde Anastasyon ile veeriyoruz.
    private LodgingType type;

    @ManyToMany(mappedBy = "lodgings")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "lodging")
    private List<Price> prices;

}
