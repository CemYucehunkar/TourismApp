package dev.patika.Tourisim.dto.response.hotel;

import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.HotelStarType;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelWithoutAnythingResponse {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private HotelStarType star;
    private Set<FacilityType> facilityTypes;



}
