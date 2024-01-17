package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.PriceManager;
import dev.patika.Tourisim.dto.request.PriceRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/agency/price")
public class PriceController {
    private final PriceManager priceManager;

    //-----------------------GET-----------------------//
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable @Valid Long id) { //@VALİD eklemezsek ne olur? -> id null olabilir.
        return new ResponseEntity<>(priceManager.getPriceWithoutAnythingResponseById(id), HttpStatus.OK);
    }

    //@valid anatasyonu ne işe yarar? daha detaylı bilgi için: https://www.baeldung.com/javax-validation
    //-----------------------SAVE-----------------------//
    @PostMapping("/save/lodging/{lodgingId}/season/{seasonId}/room/{roomId}")
    public ResponseEntity<?> save(@RequestBody PriceRequest priceRequest,
                                  @PathVariable Long lodgingId,
                                  @PathVariable Long seasonId,
                                  @PathVariable Long roomId) {
        return new ResponseEntity<>(priceManager.save(lodgingId, seasonId, roomId, priceRequest), HttpStatus.CREATED);
    }

    //-----------------------UPDATE-----------------------//
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PriceRequest priceRequest) {
        return new ResponseEntity<>(priceManager.update(id, priceRequest), HttpStatus.ACCEPTED);
    }

    //-----------------------DELETE-----------------------//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        priceManager.delete(id);
        return new ResponseEntity<>("Price with ID " + id + " deleted", HttpStatus.NO_CONTENT);
    }
}
