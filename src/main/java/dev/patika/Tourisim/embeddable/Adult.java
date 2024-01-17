package dev.patika.Tourisim.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adult {
    private String name;
    private String surname;
    private String country;
    private String identificationNumber;
}
