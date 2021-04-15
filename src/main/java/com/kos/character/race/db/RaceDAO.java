package com.kos.character.race.db;

import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceId;
import com.kos.character.race.model.RaceRepository;
import com.kos.character.utils.EntityMapper;
import com.kos.character.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RaceDAO implements RaceRepository {

    private final RaceJpaRepository raceRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public RaceDAO(RaceJpaRepository raceRepository, EntityMapper entityMapper) {
        this.raceRepository = raceRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Race> findBy(RaceId raceId) {
        return Optional.ofNullable(raceId)
                .map(RaceId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Race> findAll() {
        return raceRepository.findAll().stream().map(ModelMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Race add(Race race) {
        RaceEntity raceEntity = new RaceEntity();
        raceEntity.setName(race.getName());
        return ModelMapper.mapToModel(raceRepository.save(raceEntity));
    }

    @Override
    public Race update(Race race) {
        return ModelMapper.mapToModel(raceRepository.save(entityMapper.mapToEntity(race)));
    }

    @Override
    public void delete(Race race) {
        raceRepository.delete(entityMapper.mapToEntity(race));
    }

    private Race getFromDatabase(int heroId) {
        return raceRepository.findById(heroId).map(ModelMapper::mapToModel).orElse(null);
    }




}
