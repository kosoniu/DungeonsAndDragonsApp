package com.kos.character.utils;

import com.kos.character.clazz.db.ClassEntity;
import com.kos.character.clazz.model.Class;
import com.kos.character.clazz.model.ClassId;
import com.kos.character.hero.db.HeroEntity;
import com.kos.character.hero.model.Hero;
import com.kos.character.hero.model.HeroId;
import com.kos.character.origin.db.OriginEntity;
import com.kos.character.origin.model.Origin;
import com.kos.character.origin.model.OriginId;
import com.kos.character.proficiencies.db.ProficiencyEntity;
import com.kos.character.proficiencies.model.Proficiency;
import com.kos.character.proficiencies.model.ProficiencyId;
import com.kos.character.race.db.RaceEntity;
import com.kos.character.race.db.RaceFeatureEntity;
import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceFeature;
import com.kos.character.race.model.RaceFeatureId;
import com.kos.character.race.model.RaceId;

import java.util.stream.Collectors;

public class ModelMapper {

    public static Origin mapToModel(OriginEntity entity) {
        return new Origin(
                OriginId.of(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getProficiencies().stream().map(ModelMapper::mapToModel).collect(Collectors.toList())
        );
    }

    public static Proficiency mapToModel(ProficiencyEntity proficiencyEntity) {
        return new Proficiency(
                ProficiencyId.of(proficiencyEntity.getId()),
                proficiencyEntity.getName(),
                proficiencyEntity.getType()
        );
    }

    public static Race mapToModel(RaceEntity entity) {
        return new Race(
                RaceId.of(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getRaceFeatures().stream().map(ModelMapper::mapToModel).collect(Collectors.toSet())
        );
    }

    public static Hero mapToModel(HeroEntity entity) {
        return new Hero(
                HeroId.of(entity.getId()),
                entity.getName(),
                entity.getLevel(),
                ModelMapper.mapToModel(entity.getRace())
        );
    }

    public static RaceFeature mapToModel(RaceFeatureEntity entity) {
        return new RaceFeature(
                RaceFeatureId.of(entity.getId()),
                entity.getName(),
                entity.getDescription()
        );
    }

    public static Class mapToModel(ClassEntity entity) {
        return new Class(
                ClassId.of(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getHitDice(),
                entity.getHealthPoints(),
                entity.getHealthPointsOnHigherLevels(),
                entity.getProficiencies().stream().map(ModelMapper::mapToModel).collect(Collectors.toList())
        );
    }

}
