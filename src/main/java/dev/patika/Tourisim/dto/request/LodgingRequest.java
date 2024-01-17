package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.enums.LodgingType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LodgingRequest {
    private LodgingType type;
}
