package co.edu.usa.mintic.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reservations")
@JsonPropertyOrder({ "idReservation", "startDate", "devolutionDate", "status",  "game", "client", "score"})
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer idReservation;

    private LocalDate creationDate;
    private LocalDate startDate;
    private LocalDate devolutionDate;
    private String status;
    private Float score;

    @ManyToOne
    @JoinColumn(name="gameId")
    @JsonIgnoreProperties({"reservations"})
    private Game game;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}
