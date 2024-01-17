package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.HotelManager;
import dev.patika.Tourisim.dto.request.HotelRequest;
import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.LodgingType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController// ne işe yarar? -> bu classın bir controller olduğunu belirtir.
@RequiredArgsConstructor// ne işe yarar? -> final olan değişkenlerin constructorlarını oluşturur.
@RequestMapping("/v1/agency/hotel")
public class HotelController {
    private final HotelManager hotelManager;

    //-----------------------SAVE-----------------------//
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid HotelRequest hotelRequest) {
        return new ResponseEntity<>(hotelManager.save(hotelRequest), HttpStatus.CREATED);
    }

    //-----------------------GET-----------------------//
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return new ResponseEntity<>(hotelManager.getHotelWithoutAnythingResponse(id), HttpStatus.OK);
    }

    //-----------------------UPDATE-----------------------//
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid HotelRequest hotelRequest) {
        return new ResponseEntity<>(hotelManager.update(id, hotelRequest), HttpStatus.ACCEPTED);
    }



    //-----------------------DELETE-----------------------//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        hotelManager.delete(id);
        return new ResponseEntity<>("Hotel with ID " + id + " deleted", HttpStatus.OK);
    }

    //-----------------------SAVE Facility-----------------------//
    @PutMapping("/save-lodging/hotel/{hotelId}/facility-type/{facilityType}")
    public ResponseEntity<?> saveFacility(@PathVariable Long hotelId, @PathVariable FacilityType facilityType) {
        return ResponseEntity.ok(hotelManager.addFacility(hotelId, facilityType));
    }

    //-----------------------Delete Facility-- Değişiklik var o yüzden PUT-----------------------//

    @PutMapping("/delete-lodging/hotel/{hotelId}/facility-type/{facilityType}")
    public ResponseEntity<?> deleteFacility(@PathVariable Long hotelId, @PathVariable FacilityType facilityType) {
        return ResponseEntity.ok(hotelManager.deleteFacility(hotelId, facilityType));
    }


}
