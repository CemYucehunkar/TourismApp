package dev.patika.Tourisim.dto.response.season;

import dev.patika.Tourisim.dto.response.hotel.HotelResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeasonWithoutHotelResponse {
    private Long id;
    private String name;
    private String startDate;
    private String endDate;

}
