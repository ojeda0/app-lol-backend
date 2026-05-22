package ies.alcores.web.controllers;

import ies.alcores.persistence.models.Character;
import ies.alcores.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<Character>> getAll() {

        return ResponseEntity.ok(this.characterService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getById(@PathVariable final String id) {

        return this.characterService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody Character character) {

        return Optional.ofNullable(this.characterService.save(character)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());

    }


}
