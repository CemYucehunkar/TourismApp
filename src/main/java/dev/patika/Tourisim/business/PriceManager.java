package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.PriceRepo;
import dev.patika.Tourisim.dto.request.PriceRequest;
import dev.patika.Tourisim.dto.response.price.PriceWithoutAnythingResponse;
import dev.patika.Tourisim.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceManager {
    private final PriceRepo priceRepo;
    private final ModelMapperManager modelMapperManager;
    private final SeasonManager seasonManager;
    private final RoomManager roomManager;
    private final LodgingManager lodgingManager;

    //find by id
    public Price getById(Long id) {
        return priceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Price with ID " + id + " not found"));
    }

    // get price without anything response by id
    public PriceWithoutAnythingResponse getPriceWithoutAnythingResponseById(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), PriceWithoutAnythingResponse.class);
    }
// ---------------------------SAVE METHOD---------------------------------
    public PriceWithoutAnythingResponse save(Long lodgingId, Long seasonId, Long roomId, PriceRequest priceRequest) {
        Lodging lodging = lodgingManager.getById(lodgingId);
        Season season = seasonManager.getById(seasonId);
        Room room = roomManager.getById(roomId);

        Price priceTobeSaved = modelMapperManager
                .forRequest()
                .map(priceRequest, Price.class);

        priceTobeSaved.setRoom(room);
        priceTobeSaved.setSeason(season);
        priceTobeSaved.setLodging(lodging);

        return modelMapperManager
                .forResponse()
                .map(priceRepo.save(priceTobeSaved), PriceWithoutAnythingResponse.class);


    }
// ---------------------------UPDATE METHOD---------------------------------
    public PriceWithoutAnythingResponse update(Long id, PriceRequest priceRequest) {
        getById(id);

        Price priceToBeUpdated = modelMapperManager
                .forRequest()
                .map(priceRequest, Price.class);

        priceToBeUpdated.setId(id);

        return modelMapperManager
                .forResponse()
                .map(priceRepo.save(priceToBeUpdated), PriceWithoutAnythingResponse.class);
    }

    // ---------------------------DELETE METHOD---------------------------------
    public void delete(Long id) {
        priceRepo.delete(getById(id));
    }







    //-----------------------DELETE-----------------------//
    public void deleteById(Long id) {
        priceRepo.deleteById(id);
    }
}
