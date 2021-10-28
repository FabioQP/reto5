package co.edu.usa.mintic.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.validation.constraints.Size;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer idMessage;

    @Size(max = 250, message = "La longitud del mensaje no puede ser mayor a 250 caracteres.")
    private String messageText;

    @ManyToOne
    @JoinColumn(name="gameId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Game game;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}
