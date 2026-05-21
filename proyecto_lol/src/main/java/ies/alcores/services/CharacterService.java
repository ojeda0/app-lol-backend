package ies.alcores.services;

import ies.alcores.persistence.entities.Character;
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

}
