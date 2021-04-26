package com.kos.character.proficiencies.db;

import com.kos.character.proficiencies.model.Proficiency;
import com.kos.character.proficiencies.model.ProficiencyId;
import com.kos.character.proficiencies.model.ProficiencyRepository;
import com.kos.character.utils.EntityMapper;
import com.kos.character.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProficiencyDAO implements ProficiencyRepository {

    private final ProficiencyJpaRepository proficiencyRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public ProficiencyDAO(ProficiencyJpaRepository proficiencyRepository, EntityMapper entityMapper) {
        this.proficiencyRepository = proficiencyRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Proficiency> findBy(ProficiencyId proficiencyId) {
        return Optional.ofNullable(proficiencyId)
                .map(ProficiencyId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Proficiency> findAll() {
        return proficiencyRepository.findAll().stream().map(ModelMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Proficiency add(Proficiency proficiency) {
        ProficiencyEntity proficiencyEntity = new ProficiencyEntity();
        proficiencyEntity.setName(proficiency.getName());
        proficiencyEntity.setType(proficiency.getProficiencyType());
        return ModelMapper.mapToModel(proficiencyRepository.save(proficiencyEntity));
    }

    @Override
    public Proficiency update(Proficiency proficiency) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        proficiencyRepository.deleteById(id);
    }

    private Proficiency getFromDatabase(int proficiencyId) {
        return proficiencyRepository.findById(proficiencyId).map(ModelMapper::mapToModel).orElse(null);
    }

}
