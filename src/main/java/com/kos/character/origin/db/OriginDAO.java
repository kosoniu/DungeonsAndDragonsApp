package com.kos.character.origin.db;

import com.kos.character.origin.model.Origin;
import com.kos.character.origin.model.OriginId;
import com.kos.character.origin.model.OriginRepository;
import com.kos.character.proficiencies.db.ProficiencyEntity;
import com.kos.character.proficiencies.model.Proficiency;
import com.kos.character.proficiencies.model.ProficiencyId;
import com.kos.character.utils.EntityMapper;
import com.kos.character.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OriginDAO implements OriginRepository {

    private final OriginJpaRepository originRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public OriginDAO(OriginJpaRepository originRepository, EntityMapper entityMapper) {
        this.originRepository = originRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Origin> findBy(OriginId originId) {
        return Optional.ofNullable(originId)
                .map(OriginId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll().stream().map(ModelMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Origin update(Origin origin) {
        return ModelMapper.mapToModel(originRepository.save(entityMapper.mapToEntity(origin)));
    }

    @Override
    public Origin add(Origin origin) {
        OriginEntity originEntity = new OriginEntity();
        originEntity.setName(origin.getName());
        originEntity.setProficiencies(origin.getProficiencies().stream().map(entityMapper::mapToEntity).collect(Collectors.toSet()));
        return ModelMapper.mapToModel(originRepository.save(originEntity));
    }

    @Override
    public void delete(Origin origin) {
        originRepository.delete(entityMapper.mapToEntity(origin));
    }

    private Origin getFromDatabase(int heroId) {
        return originRepository.findById(heroId).map(ModelMapper::mapToModel).orElse(null);
    }

}
