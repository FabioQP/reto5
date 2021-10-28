package co.edu.usa.mintic.reto5.service;

import co.edu.usa.mintic.reto5.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.mintic.reto5.model.Category;
import co.edu.usa.mintic.reto5.model.Client;
import co.edu.usa.mintic.reto5.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {

        var it = repository.findAll();
        var clients = new ArrayList<Client>();
        it.forEach(client -> clients.add(client));
        return clients;
    }

    public Optional<Client> getClient(int id) {
        return repository.findById(id);
    }

    public Client save(Client client) {
        if(client.getIdClient() == null) {
            return repository.save(client);
        } else {
            Optional<Client> result = repository.findById(client.getIdClient());
            if(result.isEmpty()) {
                return repository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {

        if(client.getIdClient() == null) {
            return repository.save(client);
        } else {
            Optional<Client> result = repository.findById(client.getIdClient());
            if(result.isPresent()) {

                Client existing = result.get();
                existing.setEmail(Optional.of(client.getEmail()).orElse(existing.getEmail()));
                existing.setPassword(Optional.of(client.getPassword()).orElse(existing.getPassword()));
                existing.setName(Optional.of(client.getName()).orElse(existing.getName()));
                existing.setAge(Optional.of(client.getAge()).orElse(existing.getAge()));

                if(client.getMessages() != null) { existing.setMessages(client.getMessages()); }
                if(client.getReservations() != null) { existing.setReservations(client.getReservations()); }

                return repository.save(existing);
            } else {
                return client;
            }
        }
    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}
