package co.edu.usa.mintic.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "games")
@JsonPropertyOrder({"id", "name", "developer", "year", "description", "category", "messages", "reservations"})
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Size(max = 45, message = "La longitud del nombre del desarrollador no puede ser mayor a 45 caracteres.")
    private String developer;
    private Integer year;
    @Size(max = 45, message = "La longitud del nombre del juego no puede ser mayor a 45 caracteres.")
    private String name;
    @Size(max = 250, message = "La longitud de la descripcion no puede ser mayor a 250 caracteres.")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("games")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties({"game", "client"})
    private Set<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties("game")
    private Set<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
