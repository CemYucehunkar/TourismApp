package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.HotelStarType;
import dev.patika.Tourisim.enums.LodgingType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelRequest {
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private HotelStarType star;
    private Set<FacilityType> facilityTypes;

}
