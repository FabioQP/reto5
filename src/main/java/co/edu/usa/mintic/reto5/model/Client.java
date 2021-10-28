package co.edu.usa.mintic.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer idClient;
    @Size(max = 45, message = "La longitud del correo del cliente no puede ser mayor a 45 caracteres.")
    private String email;
    @Size(max = 45, message = "La longitud de la contraseña no puede ser mayor a 45 caracteres.")
    private String password;
    @Size(max = 250, message = "La longitud del nombre del cliente no puede ser mayor a 250 caracteres.")
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public Set<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public Set<Reservation> reservations;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
