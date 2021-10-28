package co.edu.usa.mintic.reto5.controller;

import co.edu.usa.mintic.reto5.model.Game;
import co.edu.usa.mintic.reto5.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("/all")
    public List<Game> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id) {
        return service.getGame(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@Valid @RequestBody Game game) {
        return service.save(game);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@Valid @RequestBody Game game) {
        return service.update(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}

