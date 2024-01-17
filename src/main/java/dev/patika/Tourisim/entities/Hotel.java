package dev.patika.Tourisim.entities;

import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.HotelStarType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)// Enumları belirtirken bu şekilde Anastasyon ile veeriyoruz.
    private HotelStarType star;

    @ElementCollection(targetClass = FacilityType.class)
    private Set<FacilityType> facilityTypes;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Season> seasons;

    @ManyToMany
    @JoinTable(
            name = "hotel2lodging",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "lodging_id")
    )
    private List<Lodging> lodgings;
}
