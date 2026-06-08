package ies.alcores.services;

import ies.alcores.persistence.models.Character;
import ies.alcores.persistence.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    //Obtiene todos los personajes
    public List<Character> findAll() {

        return this.characterRepository.findAll();

    }

    //Obtiene un personaje dado el ID
    public Optional<Character> findById(final String id) {

        return this.characterRepository.findById(id);

    }

    //Crea un nuevo personaje
    public Character create(final Character c) {

        return this.characterRepository.save(c);

    }

    //Borra un personaje por id
    public boolean deleteById(final String id) {

        return this.characterRepository.findById(id)
                .map(c -> {
                    this.characterRepository.delete(c);
                    return true;
                })
                .orElse(false);

    }

    //Actualiza un personaje
    public Optional<Character> updateById(final String id, final Character c) {

        return this.characterRepository.findById(id)
                .map(encontrado -> {
                    c.setId(id);
                    return this.characterRepository.save(c);
                });

    }

    //Muestra los personajes con más de un rol
    public List<Character> findByRoles() {

        return this.characterRepository.findByRoles();

    }

}
