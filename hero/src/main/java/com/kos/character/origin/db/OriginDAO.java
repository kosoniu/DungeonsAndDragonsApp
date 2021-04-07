package com.kos.character.origin.db;

import com.kos.character.origin.model.Origin;
import com.kos.character.origin.model.OriginId;
import com.kos.character.origin.model.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OriginDAO implements OriginRepository {

    private final OriginJpaRepository originRepository;

    @Autowired
    public OriginDAO(OriginJpaRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public Optional<Origin> findBy(OriginId originId) {
        return Optional.ofNullable(originId)
                .map(OriginId::asInt)
                .map(this::getFromDatabase);
    }

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Origin update(Origin origin) {
        return this.mapToModel(originRepository.save(mapToEntity(origin)));
    }

    @Override
    public Origin add(Origin origin) {
        OriginEntity originEntity = new OriginEntity();
        originEntity.setName(origin.getName());
        return this.mapToModel(originRepository.save(originEntity));
    }

    @Override
    public void delete(Origin origin) {
        originRepository.delete(mapToEntity(origin));
    }

    private Origin getFromDatabase(int heroId) {
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
