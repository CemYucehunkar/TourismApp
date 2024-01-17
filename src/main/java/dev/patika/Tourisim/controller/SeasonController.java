package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.SeasonManager;
import dev.patika.Tourisim.dto.request.SeasonRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/agency/season")
public class SeasonController {

    private final SeasonManager seasonManager;

    //-----------------------SAVE-----------------------//
    @PostMapping("/save/hotel/{hotelId}")
    public ResponseEntity<?> save(@PathVariable Long hotelId , @RequestBody @Valid SeasonRequest seasonRequest) {
        return new ResponseEntity<>(seasonManager.save(hotelId , seasonRequest), HttpStatus.CREATED);
    }

    //-----------------------GET-----------------------//
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return new ResponseEntity<>(seasonManager.getSeasonResponse(id), HttpStatus.OK);
    }

    //-----------------------UPDATE-----------------------//
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid SeasonRequest seasonRequest) {
        return new ResponseEntity<>(seasonManager.update(id, seasonRequest), HttpStatus.ACCEPTED);
    }

    //-----------------------DELETE-----------------------//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        seasonManager.delete(id);
        return new ResponseEntity<>("Season with ID " + id + " deleted", HttpStatus.OK);
    }


    //-----------------------GET ALL-----------------------//
    @GetMapping("/get/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(seasonManager.getAllSeasonWithoutHotelResponses(), HttpStatus.OK);
    }
    
}
