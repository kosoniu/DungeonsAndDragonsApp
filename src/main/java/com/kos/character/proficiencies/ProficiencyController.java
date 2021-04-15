package com.kos.character.proficiencies;

import com.kos.character.proficiencies.model.Proficiency;
import com.kos.character.proficiencies.model.ProficiencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/proficiencies")
public class ProficiencyController {

    private final ProficiencyRepository proficiencyRepository;

    @Autowired
    public ProficiencyController(ProficiencyRepository proficiencyRepository) {
        this.proficiencyRepository = proficiencyRepository;
    }

    @GetMapping
    public List<Proficiency> findAll() { return proficiencyRepository.findAll(); }

    @PostMapping
    public Proficiency add(@RequestBody Proficiency proficiency) { return proficiencyRepository.add(proficiency); }

}
