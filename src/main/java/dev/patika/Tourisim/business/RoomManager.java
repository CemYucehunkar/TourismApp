package dev.patika.Tourisim.business;

import dev.patika.Tourisim.core.mapper.ModelMapperManager;
import dev.patika.Tourisim.dao.RoomRepo;
import dev.patika.Tourisim.dto.request.RoomRequest;
import dev.patika.Tourisim.dto.response.room.RoomResponse;
import dev.patika.Tourisim.dto.response.room.RoomWithoutHotelResponse;
import dev.patika.Tourisim.entities.Hotel;
import dev.patika.Tourisim.entities.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomManager {
    private final RoomRepo roomRepo;
    private final HotelManager hotelManager;
    private final ModelMapperManager modelMapperManager;

    //-----------------------GET-----------------------//
    public Room getById(Long id) {
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room with ID " + id + " not found"));
    }


    // Get room response
    public RoomResponse getRoomResponseById(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), RoomResponse.class);
    }

    // get room without hotel

    public RoomWithoutHotelResponse getRoomWithoutHotelResponseById(Long id) {
        return modelMapperManager
                .forResponse()
                .map(getById(id), RoomWithoutHotelResponse.class);
    }

    //-----------------------SAVE-----------------------//
    public RoomResponse save(Long hotelId, RoomRequest roomRequest) {
        Hotel checkHotel = hotelManager.getById(hotelId);

        Room roomSave = modelMapperManager// model mapper ne için kullanılır? model mapper ne işe yarar? model mapper nasıl kullanılır?
                // Şunun için kullanılır: ModelMapper, Java sınıfları arasında dönüşüm yapmak için kullanılan bir kütüphanedir.
                .forRequest().// ModelMapperManager class'ında forRequest() methodu oluşturduk. Bunun sebebi nedir? Bu method ne işe yarar? Bu method nasıl kullanılır?
                        map(roomRequest, Room.class);

        roomSave.setHotel(checkHotel);// eğer böyle bir otel varsa bu oteli roomSave içine ekle.

        return modelMapperManager
                .forResponse()
                .map(roomRepo.save(roomSave), RoomResponse.class);

    }

    //-----------------------UPDATE-----------------------//
    public RoomResponse update(Long id, RoomRequest roomRequest) {
        Room room = getById(id);

        Room roomUpdate = modelMapperManager
                .forRequest().
                map(roomRequest, Room.class);
        roomUpdate.setId(id); // neden id'yi set ettik? id'yi set etmezsek ne olur? id'yi set etmek zorunlu mu?
        //Çünkü id'yi set etmezsek id null olarak kalır ve bu da hata verir. Evet zorunlu.
        roomUpdate.setHotel(room.getHotel());
        // Burada neden oteli de set etmedik? Otelin id'sini set etmedik. Çünkü otel değişmeyecek. Otelin id'si değişmeyecek.
        //Nasıl yani? Otelin id'si değişmeyecek ama otel değişecek. Otel değişecek ama otelin id'si değişmeyecek. Nasıl yani?
        return modelMapperManager
                .forResponse()
                .map(roomRepo.save(roomUpdate), RoomResponse.class);
    }

    //-----------------------DELETE-----------------------//
    public void delete(Long id) {
        roomRepo.deleteById(id);
    }
}
