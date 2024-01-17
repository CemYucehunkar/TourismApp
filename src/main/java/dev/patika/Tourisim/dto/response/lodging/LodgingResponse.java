package dev.patika.Tourisim.dto.response.lodging;

import dev.patika.Tourisim.dto.response.price.PriceWithoutAnythingResponse;
import dev.patika.Tourisim.dto.response.hotel.HotelWithoutAnythingResponse;
import dev.patika.Tourisim.enums.LodgingType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LodgingResponse {
    private  Long id;

    private LodgingType type;

    private List<HotelWithoutAnythingResponse> hotels;

    private List<PriceWithoutAnythingResponse> prices;
}
