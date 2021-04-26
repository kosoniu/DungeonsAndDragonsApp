package com.kos.character.race;

import com.kos.character.race.model.Race;
import com.kos.character.race.model.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/races")
public class RaceController {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping
    public List<Race> findAll() { return raceRepository.findAll(); }

    @PostMapping
    public Race add(@RequestBody Race race) { return raceRepository.add(race); }

    @PutMapping
    public Race update(@RequestBody Race race) { return raceRepository.update(race); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { raceRepository.delete(id);}
}
