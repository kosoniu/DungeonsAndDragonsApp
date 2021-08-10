package com.kos.character.utils;

import com.kos.character.clazz.db.ClassEntity;
import com.kos.character.clazz.db.ClassJpaRepository;
import com.kos.character.clazz.model.Class;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
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

    @Autowired
    private ClassJpaRepository classRepository;

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

    public HeroEntity mapToEntity(Hero hero) {
        HeroEntity heroEntity = heroRepository.findById(hero.getHeroId().asInt()).orElseThrow(EntityNotFoundException::new);
        RaceEntity raceEntity = raceRepository.findById(hero.getRace().getRaceId().asInt()).orElseThrow(EntityNotFoundException::new);
        ClassEntity classEntity = classRepository.findById(hero.getClazz().getClassId().asInt()).orElseThrow(EntityNotFoundException::new);
        OriginEntity originEntity = originRepository.findById(hero.getOrigin().getOriginId().asInt()).orElseThrow(EntityNotFoundException::new);

        heroEntity.setLevel(hero.getLevel());
        heroEntity.setName(hero.getName());
        heroEntity.setRace(raceEntity);
        heroEntity.setClazz(classEntity);
        heroEntity.setOrigin(originEntity);

        return heroEntity;
    }

    public ClassEntity mapToEntity(Class clazz) {
        ClassEntity classEntity = classRepository.findById(clazz.getClassId().asInt()).orElseGet(ClassEntity::new);
        classEntity.setId(clazz.getClassId().asInt());
        classEntity.setName(clazz.getName());
        classEntity.setDescription(clazz.getDescription());
        classEntity.setHitDice(clazz.getHitDice());
        classEntity.setHealthPoints(clazz.getHealthPoints());
        classEntity.setHealthPointsOnHigherLevels(clazz.getHealthPointsOnHigherLevels());
        classEntity.setProficiencies(clazz.getProficiencies().stream().map(this::mapToEntity).collect(Collectors.toSet()));
        return classEntity;
    }
}
