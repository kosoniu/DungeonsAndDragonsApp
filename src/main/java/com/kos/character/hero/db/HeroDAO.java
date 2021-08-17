package com.kos.character.hero.db;

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
public class HeroDAO implements HeroRepository {

    private final HeroJpaRepository heroRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public HeroDAO(HeroJpaRepository heroRepository, EntityMapper entityMapper) {
        this.heroRepository = heroRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Hero> findBy(HeroId heroId) {
        return Optional.ofNullable(heroId)
                .map(HeroId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll().stream().map(ModelMapper::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Hero update(Hero hero) {
        return ModelMapper.mapToModel(heroRepository.save(entityMapper.mapToEntity(hero)));
    }

    @Override
    public Hero add(Hero hero) {
        HeroEntity heroEntity = new HeroEntity();

        heroEntity.setName(hero.getName());
        heroEntity.setLevel(hero.getLevel());
        heroEntity.setOrigin(entityMapper.mapToEntity(hero.getOrigin()));
        heroEntity.setClazz(entityMapper.mapToEntity(hero.getClazz()));
        heroEntity.setRace(entityMapper.mapToEntity(hero.getRace()));

        return ModelMapper.mapToModel(heroRepository.save(heroEntity));
    }

    @Override
    public void delete(Integer id) {
        heroRepository.deleteById(id);
    }

    private Hero getFromDatabase(int heroId) {
        return heroRepository.findById(heroId).map(ModelMapper::mapToModel).orElse(null);
    }
}
