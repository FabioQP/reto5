package co.edu.usa.mintic.reto5.service;

import co.edu.usa.mintic.reto5.model.Category;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.mintic.reto5.model.Client;
import co.edu.usa.mintic.reto5.model.Game;
import co.edu.usa.mintic.reto5.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> findAll() {

        var it = repository.findAll();
        var games = new ArrayList<Game>();
        it.forEach(game -> games.add(game));
        return games;
    }

    public Optional<Game> getGame(int id) {
        return repository.findById(id);
    }

    public Game save(Game game) {
        if(game.getId() == null) {
            return repository.save(game);
        } else {
            Optional<Game> result = repository.findById(game.getId());
            if(result.isEmpty()) {
                return repository.save(game);
            } else {
                return game;
            }
        }
    }

    public Game update(Game game) {

        if(game.getId() == null) {
            return repository.save(game);
        } else {
            Optional<Game> result = repository.findById(game.getId());
            if(result.isPresent()) {

                Game existing = result.get();
                existing.setName(Optional.of(game.getName()).orElse(existing.getName()));
                existing.setDescription(Optional.of(game.getDescription()).orElse(existing.getDescription()));
                existing.setDeveloper(Optional.of(game.getDeveloper()).orElse(existing.getDeveloper()));
                existing.setYear(Optional.of(game.getYear()).orElse(existing.getYear()));

                if(game.getCategory() != null) { existing.setCategory(game.getCategory()); }
                if(game.getMessages() != null) { existing.setMessages(game.getMessages()); }
                if(game.getReservations() != null) { existing.setReservations(game.getReservations()); }

                return repository.save(existing);
            } else {
                return game;
            }
        }
    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}
