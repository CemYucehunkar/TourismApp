package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.SeasonRepo;
import dev.patika.Tourisim.dto.request.SeasonRequest;
import dev.patika.Tourisim.dto.response.hotel.HotelWithoutAnythingResponse;
import dev.patika.Tourisim.dto.response.season.SeasonResponse;
import dev.patika.Tourisim.dto.response.season.SeasonWithoutHotelResponse;
import dev.patika.Tourisim.entities.Hotel;
import dev.patika.Tourisim.entities.Season;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class
SeasonManager {

    private final SeasonRepo seasonRepo;
    private final ModelMapperManager modelMapperManager;
    private final HotelManager hotelManager;


    // ---------------------------GET BY ID METHOD---------------------------------
    public Season getById(Long id) {
        return seasonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Season with ID " + id + " not found"));
    }


    // ---------------------------GET ONE METHOD WİTHOUT HOTEL---------------------------------

    public SeasonWithoutHotelResponse getSeasonWithoutHotelResponse(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), SeasonWithoutHotelResponse.class);
    }

    // ---------------------------GET ALL METHOD WİTHOUT HOTEL---------------------------------
    public List<SeasonWithoutHotelResponse> getAllSeasonWithoutHotelResponses() {
        return seasonRepo.findAll().stream().map(season -> modelMapperManager
                        .forResponse()
                        .map(season, SeasonWithoutHotelResponse.class))
                .toList();
        // Liste şeklimnde çekeceğimiz tüm bilgiller için STREAM yapısını kullanmamız lazım.

    }


    // ---------------------------GET ONE METHOD---------------------------------
    public SeasonResponse getSeasonResponse(Long id) {
        return modelMapperManager
                .forResponse()
                .map((getById(id)), SeasonResponse.class);
    }

    // ---------------------------GET ALL METHOD---------------------------------

    public List<SeasonResponse> getAllSeasonResponse() {
        return seasonRepo.findAll().stream().map(seasons -> modelMapperManager
                        .forResponse()
                        .map(seasons, SeasonResponse.class))
                .toList();
        // Liste şeklimnde çekeceğimiz tüm bilgiller için STREAM yapısını kullanmamız lazım.
        // season  diye genel bir değişken tanımladık. Bu değişkeni kullanarak seasonRepo.findAll() methodunu çağırdık.

    }


    //---------------------------SAVE METHOD---------------------------------
    public SeasonWithoutHotelResponse save(Long hotelId, SeasonRequest seasonRequest) {
        Hotel checkHotel = hotelManager.getById(hotelId);// bu şekilde belli bir otel id sini sorgulayıp çekebiliriz.
        // bu otel id sine direk sezonu bağlayabiliriz.

        Season seasonToBeSaved = modelMapperManager
                .forRequest().
                map((seasonRequest), Season.class);

        seasonToBeSaved.setHotel(checkHotel);// bu şekilde setliyoruz.

        return modelMapperManager
                .forResponse()
                .map(seasonRepo.save(seasonToBeSaved), SeasonWithoutHotelResponse.class);

    }


    // ---------------------------UPDATE METHOD---------------------------------
    public SeasonWithoutHotelResponse update(Long id, SeasonRequest seasonRequest) {
        getById(id);
        Season seasonToBeUpdated = modelMapperManager
                .forRequest()
                .map(seasonRequest, Season.class);
        seasonToBeUpdated.setId(id);
        return modelMapperManager
                .forResponse()
                .map(seasonRepo.save(seasonToBeUpdated), SeasonWithoutHotelResponse.class);
    }

    //---------------------------DELETE METHOD---------------------------------
    public void delete(Long id) {
        seasonRepo.delete(getById(id));
    }

}
