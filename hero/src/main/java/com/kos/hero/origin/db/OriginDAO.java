package com.kos.hero.origin.db;

import com.kos.hero.character.db.HeroEntity;
import com.kos.hero.character.model.Hero;
import com.kos.hero.character.model.HeroId;
import com.kos.hero.origin.model.Origin;
import com.kos.hero.origin.model.OriginId;
import com.kos.hero.origin.model.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OriginDAO implements OriginRepository {

    private OriginJpaRepository originRepository;

    @Autowired
    public OriginDAO(OriginJpaRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public Optional<Origin> findBy(OriginId originId) {
        return Optional.ofNullable(originId)
                .map(OriginId::asInt)
                .map(this::getHeroFromDatabase);
    }

    @Override
    public List<Origin> findAll() {
        return null;
    }

    @Override
    public Origin update(Origin origin) {
        return null;
    }

    @Override
    public Origin add(Origin origin) {
        return null;
    }

    @Override
    public void delete(Origin origin) {

    }

    private Origin getHeroFromDatabase(int heroId) {
        return originRepository.findById(heroId).map(this::mapToModel).orElse(null);
    }

    private OriginEntity mapToEntity(Origin origin) {
        OriginEntity originEntity = originRepository.findById(origin.getOriginId().asInt()).orElseThrow(IllegalArgumentException::new);
        originEntity.setName(origin.getName());
        return originEntity;
    }

    private Origin mapToModel(OriginEntity entity) {
        return new Origin(
                OriginId.of(entity.getId()),
                entity.getName()
        );
    }

}
