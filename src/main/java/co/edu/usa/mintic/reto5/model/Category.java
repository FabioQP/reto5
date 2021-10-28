package co.edu.usa.mintic.reto5.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Size(max = 45, message = "La longitud del nombre de la categoria no puede ser mayor a 45 caracteres.")
    private String name;
    @Size(max = 250, message = "La longitud de la descripcion no puede ser mayor a 250 caracteres.")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private Set<Game> games;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
