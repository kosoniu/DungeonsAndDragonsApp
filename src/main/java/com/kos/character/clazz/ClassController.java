package com.kos.character.clazz;

import com.kos.character.clazz.model.Class;
import com.kos.character.clazz.model.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/classes")
public class ClassController {

    private final ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @GetMapping
    public List<Class> findAll() { return classRepository.findAll(); }

    @PostMapping
    public Class add(@RequestBody Class clazz) { return classRepository.add(clazz); }

    @PutMapping
    public Class update(@RequestBody Class clazz) { return classRepository.update(clazz); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { classRepository.delete(id); }

}
