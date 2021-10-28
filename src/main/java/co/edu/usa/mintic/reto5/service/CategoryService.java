package co.edu.usa.mintic.reto5.service;

import co.edu.usa.mintic.reto5.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.mintic.reto5.model.Category;
import co.edu.usa.mintic.reto5.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        var it = repository.findAll();
        var categories = new ArrayList<Category>();
        it.forEach(category -> categories.add(category));
        return categories;
    }

    public Optional<Category> getCategory(int id) {

        return repository.findById(id);
    }

    public Category save(Category category) {

        if(category.getId() == null) {
            return repository.save(category);
        } else {
            Optional<Category> result = repository.findById(category.getId());
            if(result.isEmpty()) {
                return repository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {

        if(category.getId() == null) {
            return repository.save(category);
        } else {
            Optional<Category> result = repository.findById(category.getId());
            if(result.isPresent()) {

                Category existing = result.get();
                existing.setName(Optional.of(category.getName()).orElse(existing.getName()));
                existing.setDescription(Optional.of(category.getDescription()).orElse(existing.getDescription()));

                return repository.save(existing);
            } else {
                return category;
            }
        }


    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}
