package com.kos.character.clazz.db;

import com.kos.character.clazz.model.Class;
import com.kos.character.clazz.model.ClassId;
import com.kos.character.clazz.model.ClassRepository;
import com.kos.character.hero.db.HeroEntity;
import com.kos.character.hero.db.HeroJpaRepository;
import com.kos.character.hero.model.Hero;
import com.kos.character.hero.model.HeroId;
import com.kos.character.hero.model.HeroRepository;
import com.kos.character.utils.EntityMapper;
import com.kos.character.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClassDAO implements ClassRepository {

    private final ClassJpaRepository classRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public ClassDAO(ClassJpaRepository classRepository, EntityMapper entityMapper) {
        this.classRepository = classRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Class> findBy(ClassId classId) {
        return Optional.ofNullable(classId)
                .map(ClassId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll().stream().map(ModelMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Class update(Class clazz) {
        return ModelMapper.mapToModel(classRepository.save(entityMapper.mapToEntity(clazz)));
    }

    @Override
    public Class add(Class clazz) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(clazz.getClassId().asInt());
        classEntity.setName(clazz.getName());

        return ModelMapper.mapToModel(classRepository.save(classEntity));
    }

    @Override
    public void delete(Integer id) {
        classRepository.deleteById(id);
    }

    private Class getFromDatabase(int classId) {
        return classRepository.findById(classId).map(ModelMapper::mapToModel).orElse(null);
    }
}
