package com.kos.character.clazz.model;

import com.kos.character.hero.model.Hero;
import com.kos.character.hero.model.HeroId;

import java.util.List;
import java.util.Optional;

public interface ClassRepository {

    Optional<Class> findBy(ClassId classId);

    List<Class> findAll();

    Class update(Class clazz);

    Class add(Class clazz);

    void delete(Integer id);

}
