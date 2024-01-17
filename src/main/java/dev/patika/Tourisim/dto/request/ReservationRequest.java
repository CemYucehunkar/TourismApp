package dev.patika.Tourisim.dto.request;

import dev.patika.Tourisim.dto.response.room.RoomResponse;
import dev.patika.Tourisim.embeddable.Adult;
import dev.patika.Tourisim.embeddable.Child;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationRequest {
    private String contactName;
    private String contactPhone;
    private String contactMail;
    private String note;
    private List<Adult> adultInformation;
    private List<Child> childInformation;
    private LocalDate arrival;
    private LocalDate departure;
    private RoomResponse  room;
}
