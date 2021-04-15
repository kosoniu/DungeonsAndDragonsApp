package com.kos.character.hero.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroJpaRepository extends JpaRepository<HeroEntity, Integer> {
}
