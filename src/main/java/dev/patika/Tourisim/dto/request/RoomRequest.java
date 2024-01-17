package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.dto.response.hotel.HotelResponse;
import dev.patika.Tourisim.enums.RoomContain;
import dev.patika.Tourisim.enums.RoomType;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomRequest {
    private RoomType roomType;
    private int stock;
    private Set<RoomContain> roomContains;


}
