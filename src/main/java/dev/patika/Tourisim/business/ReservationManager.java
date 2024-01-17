package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.ReservationRepo;
import dev.patika.Tourisim.dto.request.ReservationRequest;
import dev.patika.Tourisim.dto.response.ReservationResponse;
import dev.patika.Tourisim.entities.Reservation;
import dev.patika.Tourisim.entities.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationManager {

    private final ReservationRepo reservationRepo;
    private final ModelMapperManager modelMapperManager;
    private final RoomManager roomManager;


    // ---------------------------FİND BY ID METHOD---------------------------------
    public Reservation getById(Long id){
        return reservationRepo.findById(id).orElseThrow(() -> new RuntimeException("Reservation with ID " + id + " not found"));
    }

    // ---------------------------GET---------------------------------
    public ReservationResponse get(Long id){
        return modelMapperManager.forResponse().map(getById(id), ReservationResponse.class);
    }

    // ---------------------------SAVE---------------------------------
    public ReservationResponse save(Long roomId ,ReservationRequest reservationRequest){
        Room checkRoom = roomManager.getById(roomId);

        Reservation reservationToBeSaved=modelMapperManager.forRequest()
                .map(reservationRequest, Reservation.class);

        reservationToBeSaved.setRoom(checkRoom);


        return modelMapperManager.forResponse()
                .map(reservationRepo.save(reservationToBeSaved), ReservationResponse.class);
    }

    // ---------------------------UPDATE---------------------------------


    public ReservationResponse update(Long id, ReservationRequest reservationRequest ,Long roomId){
        getById(id);
        Room checkRoom = roomManager.getById(roomId);

        Reservation reservationToBeUpdated=modelMapperManager.forRequest()
                .map(reservationRequest, Reservation.class);

        reservationToBeUpdated.setId(id);
        reservationToBeUpdated.setRoom(checkRoom);
        //Bu metot bir

        return modelMapperManager.forResponse()
                .map(reservationRepo.save(reservationToBeUpdated), ReservationResponse.class);
    }

    public void delete(Long id) {
        reservationRepo.delete(getById(id));
    }
}
