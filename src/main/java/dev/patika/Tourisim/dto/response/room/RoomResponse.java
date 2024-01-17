package dev.patika.Tourisim.dto.response.room;

import dev.patika.Tourisim.dto.response.hotel.HotelWithoutAnythingResponse;
import dev.patika.Tourisim.entities.Hotel;
import dev.patika.Tourisim.enums.RoomContain;
import dev.patika.Tourisim.enums.RoomType;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomResponse {
    private Long id;
    private RoomType roomType;
    private int stock;
    private Set<RoomContain> roomContains;
   private HotelWithoutAnythingResponse hotel;
}
