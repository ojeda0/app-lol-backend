package ies.alcores.web.controllers;

import ies.alcores.persistence.models.Character;
import ies.alcores.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    public ResponseEntity<Character> create(@RequestBody final Character character) {

        Character creado = this.characterService.create(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final String id) {

        return characterService.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateById(@PathVariable final String id, @RequestBody final Character c) {

        return this.characterService.updateById(id, c)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/filtro/multirol")
    public ResponseEntity<List<Character>> findByRoles() {

        List<Character> multirolCharacters = this.characterService.findByRoles();

        if (multirolCharacters.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(multirolCharacters);

    }

    @GetMapping("/tanques")
    public ResponseEntity<List<Character>> findByRolesTank() {

        return ResponseEntity.ok(this.characterService.findByRolesTank());

    }


}
