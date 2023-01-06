package br.com.igor.port.MyProject.resource;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.port.MyProject.entities.Category;
import br.com.igor.port.MyProject.repository.CategoryRepository;

@RestController
@RequestMapping(value = "/Category")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/categoryCreate")
    public String createCategory(Category category) {
        try {
            categoryRepository.save(category);
            return "the category " + category.getName() + " Id " + category.getId() + " was successfully created";

        } catch (Exception e) {
            return "Cannot create category because need more parameters\n";
        }

    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return ResponseEntity.ok().body(categoryList);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Category category = categoryRepository.findById(id).get();
            return ResponseEntity.ok().body(category);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Not Found");
        }
    }

    @PutMapping("/update")
    public Object updateCategory(@RequestParam Long id, @RequestParam String name) {

        try {
            Category category = categoryRepository.findById(id).get();
            category.setName(name);
            categoryRepository.save(category);
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            return "id: " + id + " Cannot update because id not Found\n" + "STACK\n" + e;
        }
    }

    @DeleteMapping("/delete")
    public Object deleteProduct(@RequestParam Long id) {
        try {
            categoryRepository.deleteById(id);
            return "Category Deleted";
        } catch (Exception e) {
            return "id: " + id + " Cannot delete \n" + "STACK\n" + e;
        }
    }
}
