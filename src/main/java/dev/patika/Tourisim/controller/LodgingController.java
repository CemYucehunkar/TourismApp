package dev.patika.Tourisim.controller;

import dev.patika.Tourisim.business.LodgingManager;
import dev.patika.Tourisim.dto.request.LodgingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/agency/lodging")
public class LodgingController {
    private final LodgingManager lodgingManager;

    //-----------------------save-----------------------//

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LodgingRequest lodgingRequest) {
        return new ResponseEntity<>(lodgingManager.save(lodgingRequest), HttpStatus.CREATED);
    }

    //-----------------------get-----------------------//
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return new ResponseEntity<>(lodgingManager.getLodgingResponseById(id), HttpStatus.OK);
    }

    //-----------------------update-----------------------//
    @PutMapping ("/update/{id}")
    public ResponseEntity <?> update(@PathVariable Long id, @RequestBody LodgingRequest lodgingRequest){
        return new ResponseEntity<>(lodgingManager.update(id, lodgingRequest), HttpStatus.ACCEPTED);

    }

    //-----------------------delete-----------------------//
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        lodgingManager.delete(id);
        return new ResponseEntity<>("Lodging with ID " + id + " deleted", HttpStatus.OK);
    }

}
