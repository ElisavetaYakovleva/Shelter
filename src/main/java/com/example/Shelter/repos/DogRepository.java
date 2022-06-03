package com.example.Shelter.repos;

import com.example.Shelter.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository <Dog, Long> {

/*
    Optional<Dog> findByEmail(String email);
*/
}
