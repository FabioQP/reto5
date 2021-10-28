package co.edu.usa.mintic.reto5.controller;

import co.edu.usa.mintic.reto5.model.Category;
import co.edu.usa.mintic.reto5.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id) {
        return service.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@Valid @RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@Valid @RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
