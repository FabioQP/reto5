package co.edu.usa.mintic.reto5.controller;

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

import co.edu.usa.mintic.reto5.model.Category;
import co.edu.usa.mintic.reto5.model.Client;
import co.edu.usa.mintic.reto5.service.CategoryService;
import co.edu.usa.mintic.reto5.service.ClientService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return service.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@Valid @RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@Valid @RequestBody Client client) { return service.update(client); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) { return service.delete(id); }
}
