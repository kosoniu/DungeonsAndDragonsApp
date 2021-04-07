package com.kos.hero.character.db;

import com.kos.hero.character.model.Hero;
import com.kos.hero.character.model.HeroId;
import com.kos.hero.character.model.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HeroDAO implements HeroRepository {

    private HeroJpaRepository heroRepository;

    @Autowired
    public HeroDAO(HeroJpaRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Optional<Hero> findBy(HeroId heroId) {
        return Optional.ofNullable(heroId)
                .map(HeroId::asInt)
                .map(this::getHeroFromDatabase);
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

    private Hero getHeroFromDatabase(int heroId) {
        return heroRepository.findById(heroId).map(this::mapToModel).orElse(null);
    }

    private HeroEntity mapToEntity(Hero hero) {
        HeroEntity heroEntity = heroRepository.findById(hero.getHeroId().asInt()).orElseThrow(IllegalArgumentException::new);
        heroEntity.setLevel(hero.getLevel());
        heroEntity.setName(hero.getName());
        return heroEntity;
    }

    private Hero mapToModel(HeroEntity entity) {
        return new Hero(
                HeroId.of(entity.getId()),
                entity.getName(),
                entity.getLevel()
        );
    }

}
