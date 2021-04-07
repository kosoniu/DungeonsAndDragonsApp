package com.kos.character.race.db;

import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceId;
import com.kos.character.race.model.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RaceDAO implements RaceRepository {

    private final RaceJpaRepository raceRepository;

    @Autowired
    public RaceDAO(RaceJpaRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Optional<Race> findBy(RaceId raceId) {
        return Optional.ofNullable(raceId)
                .map(RaceId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Race> findAll() {
        return raceRepository.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Race add(Race race) {
        RaceEntity raceEntity = new RaceEntity();
        raceEntity.setName(race.getName());
        return this.mapToModel(raceRepository.save(raceEntity));
    }

    @Override
    public Race update(Race race) {
        return this.mapToModel(raceRepository.save(mapToEntity(race)));
    }

    @Override
    public void delete(Race race) {
        raceRepository.delete(mapToEntity(race));
    }

    private Race getFromDatabase(int heroId) {
        return raceRepository.findById(heroId).map(this::mapToModel).orElse(null);
    }

    private RaceEntity mapToEntity(Race race) {
        RaceEntity raceEntity = raceRepository.findById(race.getRaceId().asInt()).orElseThrow(IllegalArgumentException::new);
        raceEntity.setName(race.getName());
        return raceEntity;
    }

    private Race mapToModel(RaceEntity entity) {
        return new Race(
                RaceId.of(entity.getId()),
                entity.getName()
        );
    }
}
