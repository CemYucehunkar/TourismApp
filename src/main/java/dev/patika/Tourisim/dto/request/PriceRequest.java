package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.dto.response.room.RoomResponse;
import dev.patika.Tourisim.dto.response.season.SeasonResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceRequest {
    private int adultPrice;
    private int childPrice;

}
