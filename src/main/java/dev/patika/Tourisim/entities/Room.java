package dev.patika.Tourisim.entities;

import dev.patika.Tourisim.enums.RoomContain;
import dev.patika.Tourisim.enums.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private int stock;


    // ElementCollection ile yapmak istediğimiz şey RoomContain enumunun içindeki verileri veritabanında bir tablo olarak oluşturmak.
    @ElementCollection(targetClass = RoomContain.class)
    private Set<RoomContain> roomContains;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Price> prices;



}
