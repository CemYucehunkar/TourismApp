package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.HotelRepo;
import dev.patika.Tourisim.dto.request.HotelRequest;
import dev.patika.Tourisim.dto.response.hotel.HotelResponse;
import dev.patika.Tourisim.dto.response.hotel.HotelWithoutAnythingResponse;
import dev.patika.Tourisim.entities.Hotel;
import dev.patika.Tourisim.entities.Lodging;
import dev.patika.Tourisim.enums.FacilityType;
import dev.patika.Tourisim.enums.LodgingType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class HotelManager {
    private final HotelRepo hotelRepo;
    private final ModelMapperManager modelMapperManager;
    private final LodgingManager lodgingManager;

    // get by id
    public Hotel getById(Long id) {
        return hotelRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel with ID " + id + " not found"));
    }
// get hotel without anything response by id
    public HotelWithoutAnythingResponse getHotelWithoutAnythingResponse(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), HotelWithoutAnythingResponse.class);
    }
// get hotel response by id
    public HotelResponse getHotelResponse(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), HotelResponse.class);
    }
// save
    public HotelWithoutAnythingResponse save(HotelRequest hotelRequest) {
        Hotel hotelToBeSaved = modelMapperManager
                .forRequest()
                .map(hotelRequest, Hotel.class);

        return modelMapperManager
                .forResponse()
                .map(hotelRepo.save(hotelToBeSaved), HotelWithoutAnythingResponse.class);
    }
// update
    public HotelWithoutAnythingResponse update(Long id, HotelRequest hotelRequest) {
        getById(id);

        Hotel hotelToBeUpdated = modelMapperManager
                .forRequest()
                .map(hotelRequest, Hotel.class);

        hotelToBeUpdated.setId(id);

        return modelMapperManager
                .forResponse()
                .map(hotelRepo.save(hotelToBeUpdated), HotelWithoutAnythingResponse.class);
        //Neden direk return hotelRepo.save(hotelToBeUpdated); yapmadık?
        //Çünkü bu şekilde yaparsak bize HotelWithoutAnythingResponse dönmeyecek.
        //ne dönecekti? Hotel dönecekti. Bizim istediğimiz HotelWithoutAnythingResponse dönmekti.
    }
// delete
    public void delete(Long id) {
        hotelRepo.delete(getById(id));
    }


    // kullanıcıdan hotel id ve lodging type alacağız ondan sonra lodging
    // repoya yazdığımız metod ile (tabi servis aracılığı ile) istediğimiz
    // türdeki lodging objesini çekeceğiz sonra onun id'sini ve hotel id'mizi kullanarak
    // hotel2lodging many to many tablosuna
    // bunu ekleyeceğiz

    // add facility
    public Set<FacilityType> addFacility(Long hotelId, FacilityType facilityType) {
        Hotel hotel = getById(hotelId);

        Set<FacilityType> facilityTypeSet = hotel.getFacilityTypes();
        facilityTypeSet.add(facilityType);

        hotel.setFacilityTypes(facilityTypeSet);

        hotelRepo.save(hotel);

        return facilityTypeSet;
    }

    // delete facility
    public  Set<FacilityType> deleteFacility(Long hotelId, FacilityType facilityType) {
        Hotel hotel = getById(hotelId);

        Set<FacilityType> facilityTypeSet = hotel.getFacilityTypes();
        facilityTypeSet.remove(facilityType);

        hotel.setFacilityTypes(facilityTypeSet);

        hotelRepo.save(hotel);
        return facilityTypeSet;
    }
}
