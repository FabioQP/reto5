package co.edu.usa.mintic.reto5.controller;

import co.edu.usa.mintic.reto5.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import co.edu.usa.mintic.reto5.model.Client;
import co.edu.usa.mintic.reto5.model.Message;
import co.edu.usa.mintic.reto5.service.ClientService;
import co.edu.usa.mintic.reto5.service.MessageService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return service.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@Valid @RequestBody Message message) {
        return service.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@Valid @RequestBody Message message) { return service.update(message); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) { return service.delete(id); }
}
