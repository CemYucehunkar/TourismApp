package dev.patika.Tourisim.dao;

import dev.patika.Tourisim.entities.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LodgingRepo  extends JpaRepository<Lodging,Long> {
  Optional<Lodging> findByType(String type);

}
