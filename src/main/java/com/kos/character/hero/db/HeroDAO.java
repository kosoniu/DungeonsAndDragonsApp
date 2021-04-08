package com.kos.character.hero.db;

import com.kos.character.hero.model.Hero;
import com.kos.character.hero.model.HeroId;
import com.kos.character.hero.model.HeroRepository;
import com.kos.character.race.db.RaceEntity;
import com.kos.character.race.db.RaceJpaRepository;
import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HeroDAO implements HeroRepository {

    private HeroJpaRepository heroRepository;
    private RaceJpaRepository raceRepository;


    @Autowired
    public HeroDAO(HeroJpaRepository heroRepository, RaceJpaRepository raceRepository) {
        this.heroRepository = heroRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public Optional<Hero> findBy(HeroId heroId) {
        return Optional.ofNullable(heroId)
                .map(HeroId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Hero update(Hero hero) {
        return this.mapToModel(heroRepository.save(mapToEntity(hero)));
    }

    @Override
    public Hero add(Hero hero) {
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setName(hero.getName());
        heroEntity.setLevel(hero.getLevel());
        return this.mapToModel(heroRepository.save(heroEntity));
    }

    @Override
    public void delete(Hero hero) {
        heroRepository.delete(mapToEntity(hero));
    }

    private Hero getFromDatabase(int heroId) {
        return heroRepository.findById(heroId).map(this::mapToModel).orElse(null);
    }

    private HeroEntity mapToEntity(Hero hero) {
        HeroEntity heroEntity = heroRepository.findById(hero.getHeroId().asInt()).orElseThrow(IllegalArgumentException::new);
        RaceEntity raceEntity = raceRepository.findById(hero.getRace().getRaceId().asInt()).orElseThrow(IllegalArgumentException::new);
        heroEntity.setLevel(hero.getLevel());
        heroEntity.setName(hero.getName());
        heroEntity.setRace(raceEntity);
        return heroEntity;
    }

    private Hero mapToModel(HeroEntity entity) {
        return new Hero(
                HeroId.of(entity.getId()),
                entity.getName(),
                entity.getLevel(),
                this.mapToModel(entity.getRace())
        );
    }

    private Race mapToModel(RaceEntity entity) {
        return new Race(
                RaceId.of(entity.getId()),
                entity.getName()
        );
    }

}
