package com.kos.character.origin.model;

import java.util.List;
import java.util.Optional;

public interface OriginRepository {

    Optional<Origin> findBy(OriginId originId);

    List<Origin> findAll();

    Origin update(Origin origin);

    Origin add(Origin origin);

    void delete(Origin origin);

}
