package dev.patika.Tourisim.dto.response.room;

import dev.patika.Tourisim.enums.RoomContain;
import dev.patika.Tourisim.enums.RoomType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomWithoutHotelResponse {
    private Long id;
    private RoomType roomType;
    private int stock;
    private Set<RoomContain> roomContains;
}
