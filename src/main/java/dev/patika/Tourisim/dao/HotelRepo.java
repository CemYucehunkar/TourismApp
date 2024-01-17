package dev.patika.Tourisim.dao;

import dev.patika.Tourisim.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {


    @Modifying// insert update delete işlemlerinde kullanılır. Neden kullanıyoruz? Çünkü bu işlemlerden sonra commit işlemi yapılması gerekir.
   // yukarıdaki iki anatasyon arasındaki fark nedir? @Transactional sadece commit işlemi yapar, @Modifying ise commit işlemi yapar ve veritabanında değişiklik yapar.
    @Query(value = "INSERT INTO hotel2lodging(\n" +
            "\thotel_id, lodging_id)\n" +
            "\tVALUES (?1, ?2) ",nativeQuery = true)
    void saveHotel2Lodging(Long hotelId,Long lodgingId);


}
