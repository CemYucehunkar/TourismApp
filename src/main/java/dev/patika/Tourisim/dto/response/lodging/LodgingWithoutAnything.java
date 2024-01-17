package dev.patika.Tourisim.dto.response.lodging;

import dev.patika.Tourisim.enums.LodgingType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LodgingWithoutAnything {
    private  Long id;

    private LodgingType type;
}
