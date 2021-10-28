package co.edu.usa.mintic.reto5.service;

import co.edu.usa.mintic.reto5.model.Category;
import co.edu.usa.mintic.reto5.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.mintic.reto5.model.Game;
import co.edu.usa.mintic.reto5.model.Message;
import co.edu.usa.mintic.reto5.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Message> findAll() {

        var it = repository.findAll();
        var messages = new ArrayList<Message>();
        it.forEach(message -> messages.add(message));
        return messages;
    }

    public Optional<Message> getMessage(int id) {
        return repository.findById(id);
    }

    public Message save(Message message) {
        if(message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            Optional<Message> result = repository.findById(message.getIdMessage());
            if(result.isEmpty()) {
                return repository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {

        if(message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            Optional<Message> result = repository.findById(message.getIdMessage());
            if(result.isPresent()) {

                Message existing = result.get();
                existing.setMessageText(Optional.of(message.getMessageText()).orElse(existing.getMessageText()));

                if(message.getClient() != null) { existing.setClient(message.getClient()); }
                if(message.getGame() != null) { existing.setGame(message.getGame()); }

                return repository.save(existing);
            } else {
                return message;
            }
        }
    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}
