package com.kos.hero.character.db;

import org.springframework.data.jpa.repository.JpaRepository;

interface HeroJpaRepository extends JpaRepository<HeroEntity, Integer> {
}
