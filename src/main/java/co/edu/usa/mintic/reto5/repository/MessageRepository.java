package co.edu.usa.mintic.reto5.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.mintic.reto5.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
