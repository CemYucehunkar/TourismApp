package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.RoomManager;
import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dto.request.RoomRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/agency/room")
public class RoomController {
    private final RoomManager roomManager;

    //-----------------------SAVE-----------------------//
    @PostMapping("/hotel/{hotelId}")
    public ResponseEntity<?> save(@PathVariable Long hotelId, @RequestBody @Valid RoomRequest roomRequest) {
        return new ResponseEntity<>(roomManager.save(hotelId, roomRequest), HttpStatus.CREATED);
    }

    //-----------------------GET with hotel-----------------------//
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomResponse(@PathVariable Long id) {
        return new ResponseEntity<>(roomManager.getRoomResponseById(id), HttpStatus.OK);
    }

    // -----------------------GET with hotel -----------------------//
    @GetMapping("/room-without-hotel/{id}")
    public ResponseEntity<?> getRoomWithoutHotelResponse(@PathVariable Long id) {
        return new ResponseEntity<>(roomManager.getRoomWithoutHotelResponseById(id), HttpStatus.OK);
    }



    //-----------------------UPDATE-----------------------//
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid RoomRequest roomRequest) {
        return new ResponseEntity<>(roomManager.update(id, roomRequest), HttpStatus.ACCEPTED);
    }

    //-----------------------DELETE-----------------------//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roomManager.delete(id);
        return new ResponseEntity<>("Room with ID " + id + " deleted", HttpStatus.OK);
    }
}
