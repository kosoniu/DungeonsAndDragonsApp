package com.kos.hero.character;

import com.kos.hero.character.db.HeroEntity;
import com.kos.hero.character.model.Hero;
import com.kos.hero.character.model.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @PostMapping
    public Hero add(@RequestBody Hero hero) {
        return heroRepository.add(hero);
    }

    @PutMapping
    public Hero update(@RequestBody Hero hero) {
        return heroRepository.update(hero);
    }

    @DeleteMapping
    public void delete(@RequestBody Hero hero) {
        heroRepository.delete(hero);
    }

}
