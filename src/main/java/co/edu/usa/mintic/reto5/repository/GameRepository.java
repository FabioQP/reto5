package co.edu.usa.mintic.reto5.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.mintic.reto5.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
