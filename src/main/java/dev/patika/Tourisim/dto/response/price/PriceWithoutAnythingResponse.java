package dev.patika.Tourisim.dto.response.price;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceWithoutAnythingResponse {
    private Long id;
    private double price;
    private int adultPrice;
    private int childPrice;
}
