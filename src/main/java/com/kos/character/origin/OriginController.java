package com.kos.character.origin;

import com.kos.character.origin.model.Origin;
import com.kos.character.origin.model.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/origins")
public class OriginController {

    private final OriginRepository originRepository;

    @Autowired
    public OriginController(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @GetMapping
    public List<Origin> findAll() { return originRepository.findAll(); }

    @PostMapping
    public Origin add(@RequestBody Origin origin) { return originRepository.add(origin); }

    @PutMapping
    public Origin update(@RequestBody Origin origin) { return originRepository.update(origin); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { originRepository.delete(id); }

}
