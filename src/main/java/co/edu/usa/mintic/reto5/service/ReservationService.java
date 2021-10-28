package co.edu.usa.mintic.reto5.service;

import co.edu.usa.mintic.reto5.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.mintic.reto5.model.Message;
import co.edu.usa.mintic.reto5.model.Reservation;
import co.edu.usa.mintic.reto5.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> findAll() {

        var it = repository.findAll();
        var reservations = new ArrayList<Reservation>();
        it.forEach(reservation -> reservations.add(reservation));
        return reservations;
    }

    public Optional<Reservation> getReservation(int id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation) {

        reservation.setStatus("created");
        reservation.setCreationDate(LocalDate.now());

        if(reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            Optional<Reservation> result = repository.findById(reservation.getIdReservation());
            if(result.isEmpty()) {
                return repository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {

        if(reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            Optional<Reservation> result = repository.findById(reservation.getIdReservation());
            if(result.isPresent()) {

                Reservation existing = result.get();
                existing.setStatus(Optional.of(reservation.getStatus()).orElse(existing.getStatus()));
                existing.setScore(Optional.of(reservation.getScore()).orElse(existing.getScore()));
                existing.setCreationDate(Optional.of(reservation.getCreationDate()).orElse(existing.getCreationDate()));
                existing.setStartDate(Optional.of(reservation.getStartDate()).orElse(existing.getStartDate()));
                existing.setDevolutionDate(Optional.of(reservation.getDevolutionDate()).orElse(existing.getDevolutionDate()));

                if(reservation.getGame() != null) { existing.setGame(reservation.getGame()); }
                if(reservation.getClient() != null) { existing.setClient(reservation.getClient()); }

                return repository.save(existing);
            } else {
                return reservation;
            }
        }
    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}
