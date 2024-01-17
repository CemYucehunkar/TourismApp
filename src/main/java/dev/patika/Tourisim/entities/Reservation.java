package dev.patika.Tourisim.entities;


import dev.patika.Tourisim.embeddable.Adult;
import dev.patika.Tourisim.embeddable.Child;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contactName;
    private String contactPhone;
    private String contactMail;
    private String note;

    @ElementCollection(targetClass = Adult.class)
    private List<Adult> adultInformation;//embeddable classımızı burada kullanıyoruz.
    //embeddable classımızı burada kullanıyoruz. Anatasyonu sınıf içinde tanımlayıp. Burada da ElementCollection ile çağırıyoruz.

    @ElementCollection(targetClass = Child.class)// Bunu yapmamızın sebebi Child classının bir entity olmaması.
    private List<Child> childInformation;

    private LocalDate arrival;

    private LocalDate departure;

    @ManyToOne
    private Room room;


}
