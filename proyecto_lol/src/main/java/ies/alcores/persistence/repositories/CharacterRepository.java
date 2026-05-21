package ies.alcores.persistence.repositories;

import ies.alcores.persistence.entities.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {


}
