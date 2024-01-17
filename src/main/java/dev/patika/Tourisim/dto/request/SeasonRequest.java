package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.dto.response.hotel.HotelResponse;
import dev.patika.Tourisim.entities.Hotel;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeasonRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
// buraya otel id si eklersek  o otelin tüm isterlerini girmemiz gerekecek ve döngü oluşacak
    // Bunu engellemek için Manager da save metoduna otel id si ekledik. season eklerken direk otel id si ile ekleyeceğiz.
    // Bu sayede otel id si ile otel bilgilerini çekeceğiz.


    // Bunu tüm üst sınıfları olanlara ve bağlantılı sınıfları olanlara uygulayabiliriz.
}
