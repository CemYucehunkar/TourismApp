package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.LodgingRepo;
import dev.patika.Tourisim.dto.request.LodgingRequest;
import dev.patika.Tourisim.dto.response.lodging.LodgingResponse;
import dev.patika.Tourisim.dto.response.lodging.LodgingWithoutAnything;
import dev.patika.Tourisim.entities.Lodging;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LodgingManager {
    private final LodgingRepo lodgingRepo;
    private final ModelMapperManager modelMapperManager;

    // get by id
    public Lodging getById(Long id) {
        return lodgingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lodging with ID " + id + " not found"));


    }

    // get lodging response by id
    public LodgingResponse getLodgingResponseById(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), LodgingResponse.class);
    }
    // get lodging without anything by id

    public LodgingWithoutAnything getLodgingWithoutAnythingById(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), LodgingWithoutAnything.class);
    }

    // save
public LodgingWithoutAnything save ( LodgingRequest lodgingRequest) {
    Lodging lodgingToBeSaved = modelMapperManager
            .forRequest()
            .map(lodgingRequest, Lodging.class);

    return modelMapperManager
            .forResponse()
            .map(lodgingRepo.save(lodgingToBeSaved), LodgingWithoutAnything.class);
}

    // update
    public LodgingWithoutAnything update(Long id, LodgingRequest lodgingRequest) {
        getById(id);

        Lodging lodgingToBeUpdated = modelMapperManager
                .forRequest()
                .map(lodgingRequest, Lodging.class);

        lodgingToBeUpdated.setId(id);

        return modelMapperManager
                .forResponse()
                .map(lodgingRepo.save(lodgingToBeUpdated), LodgingWithoutAnything.class);
    }


    // delete
    public void delete(Long id) {
        lodgingRepo.delete(getById(id));
    }
// find by type
    public Lodging findByType(String type) { // bu method ne işe yarar? bu method nasıl kullanılır?
        // bu method ne için kullanılır?
        //Çünkü bu method ile lodging type'ına göre arama yapacağız.
        return lodgingRepo.findByType(type)
                .orElseThrow(() -> new RuntimeException("Lodging with type " + type + " not found"));
    }
}