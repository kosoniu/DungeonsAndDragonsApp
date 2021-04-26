package com.kos.character.race.model;

import java.util.List;
import java.util.Optional;

public interface RaceRepository {

    Optional<Race> findBy(RaceId raceId);

    List<Race> findAll();

    Race add(Race race);

    Race update(Race race);

    void delete(Integer id);

}
