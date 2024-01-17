package dev.patika.Tourisim.dao;

import dev.patika.Tourisim.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepo extends JpaRepository<Season,Long> {
}
