package com.kos.character.hero.model;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {

    Optional<Hero> findBy(HeroId heroId);

    List<Hero> findAll();

    Hero update(Hero hero);

    Hero add(Hero hero);

    void delete(Hero hero);

}
