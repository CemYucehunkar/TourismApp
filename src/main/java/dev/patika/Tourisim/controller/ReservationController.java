package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.ReservationManager;
import dev.patika.Tourisim.dto.request.ReservationRequest;
import dev.patika.Tourisim.entities.Room;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/v1/agency/reservation")
public class ReservationController {
   private final ReservationManager reservationManager;

//-----------------------SAVE-----------------------//
   @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ReservationRequest reservationRequest , @PathVariable Long roomId){
       return new ResponseEntity<>(reservationManager.save(roomId, reservationRequest), HttpStatus.CREATED);
    }
//-----------------------GET-----------------------//
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
       return new ResponseEntity<>(reservationManager.get(id), HttpStatus.OK);
    }
//-----------------------UPDATE-----------------------//
    @PutMapping("/update/{id}/room/{roomId}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody ReservationRequest reservationRequest,
            @PathVariable Long roomId
    ) {
       return new ResponseEntity<>(reservationManager.update(id, reservationRequest, roomId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
       reservationManager.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
