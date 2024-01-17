package dev.patika.Tourisim.dto.response.hotel;

import dev.patika.Tourisim.dto.response.season.SeasonWithoutHotelResponse;
import dev.patika.Tourisim.entities.Lodging;
import dev.patika.Tourisim.entities.Room;
import dev.patika.Tourisim.entities.Season;
import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.HotelStarType;
import lombok.*;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelResponse {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private HotelStarType star;
    private Set<FacilityType> facilityTypes;
    private List<Room> rooms;
    private List<SeasonWithoutHotelResponse> seasons;
    private List <Lodging> lodgings;
}
