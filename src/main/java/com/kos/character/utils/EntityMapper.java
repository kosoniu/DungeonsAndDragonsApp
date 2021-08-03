package com.kos.character.utils;

import com.kos.character.hero.db.HeroEntity;
import com.kos.character.hero.db.HeroJpaRepository;
import com.kos.character.hero.model.Hero;
import com.kos.character.origin.db.OriginEntity;
import com.kos.character.origin.db.OriginJpaRepository;
import com.kos.character.origin.model.Origin;
import com.kos.character.proficiencies.db.ProficiencyEntity;
import com.kos.character.proficiencies.db.ProficiencyJpaRepository;
import com.kos.character.proficiencies.model.Proficiency;
import com.kos.character.race.db.RaceEntity;
import com.kos.character.race.db.RaceFeatureEntity;
import com.kos.character.race.db.RaceFeatureJpaRepository;
import com.kos.character.race.db.RaceJpaRepository;
import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceFeature;
import com.kos.character.race.model.RaceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

    @Autowired
    private OriginJpaRepository originRepository;

    @Autowired
    private ProficiencyJpaRepository proficiencyRepository;

    @Autowired
    private RaceJpaRepository raceRepository;

    @Autowired
    private HeroJpaRepository heroRepository;

    @Autowired
    private RaceFeatureJpaRepository raceFeatureRepository;

    public OriginEntity mapToEntity(Origin origin) {
        OriginEntity originEntity = originRepository.findById(origin.getOriginId().asInt()).orElseGet(OriginEntity::new);
        originEntity.setName(origin.getName());
        originEntity.setDescription(origin.getDescription());
        originEntity.setProficiencies(origin.getProficiencies().stream().map(this::mapToEntity).collect(Collectors.toSet()));
        return originEntity;
    }

    public ProficiencyEntity mapToEntity(Proficiency proficiency) {
        ProficiencyEntity proficiencyEntity = proficiencyRepository.findById(proficiency.getProficiencyId().asInt()).orElseGet(ProficiencyEntity::new);
        proficiencyEntity.setName(proficiency.getName());
        proficiencyEntity.setType(proficiency.getProficiencyType());
        return proficiencyEntity;
    }

    public RaceEntity mapToEntity(Race race) {
        RaceEntity raceEntity = raceRepository.findById(race.getRaceId().asInt()).orElseGet(RaceEntity::new);
        raceEntity.setName(race.getName());
        raceEntity.setDescription(race.getDescription());

        Set<RaceFeatureEntity> raceFeatureEntities = new HashSet<>();

        race.getRaceFeatures().forEach(raceFeature -> raceFeatureEntities.add(mapToEntity(raceFeature)));
        raceEntity.setRaceFeatures(raceFeatureEntities);

        return raceEntity;
    }

    public RaceFeatureEntity mapToEntity(RaceFeature raceFeature) {
        RaceFeatureEntity raceFeatureEntity = raceFeatureRepository.findById(raceFeature.getRaceFeatureId().asInt()).orElseGet(RaceFeatureEntity::new);

        raceFeatureEntity.setName(raceFeature.getName());
        raceFeatureEntity.setDescription(raceFeature.getDescription());
        return raceFeatureEntity;
    }

    public RaceFeatureEntity mapToEntity(RaceFeature raceFeature, RaceId raceId) {
        RaceFeatureEntity raceFeatureEntity = raceFeatureRepository.findById(raceFeature.getRaceFeatureId().asInt()).orElseGet(RaceFeatureEntity::new);

        raceFeatureEntity.setName(raceFeature.getName());
        raceFeatureEntity.setDescription(raceFeature.getDescription());
        return raceFeatureEntity;
    }

    public HeroEntity mapToEntity(Hero hero) {
        HeroEntity heroEntity = heroRepository.findById(hero.getHeroId().asInt()).orElseGet(HeroEntity::new);
        RaceEntity raceEntity = raceRepository.findById(hero.getRace().getRaceId().asInt()).orElseGet(RaceEntity::new);
        heroEntity.setLevel(hero.getLevel());
        heroEntity.setName(hero.getName());
        heroEntity.setRace(raceEntity);
        return heroEntity;
    }

}
