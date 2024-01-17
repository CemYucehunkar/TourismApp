package dev.patika.Tourisim.dto.response.price;

import dev.patika.Tourisim.dto.response.room.RoomResponse;
import dev.patika.Tourisim.entities.Season;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceResponse {
    private Long id;
    private double price;
    private int adultPrice;
    private int childPrice;
    private Season season;
    private RoomResponse room;

}
