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

import br.com.igor.port.MyProject.entities.Product;
import br.com.igor.port.MyProject.repository.ProductRepository;

@RestController
@RequestMapping(value = "/Product")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/ProductCreate")
    public String createProduct(Product product) {
        try {
            productRepository.save(product);
            return "the Product " + product.getName() + " Id " + product.getId() + " was successfully created";

        } catch (Exception e) {
            return "Cannot create Product because need more parameters\n";
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = productRepository.findAll();
        return ResponseEntity.ok().body(productList);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Product product = productRepository.findById(id).get();
            return ResponseEntity.ok().body(product);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Not Found");
        }
    }

    @PutMapping("/update")
    public Object updateProduct(@RequestParam Long id, @RequestParam String name, @RequestParam Double price) {

        try {
            Product product = productRepository.findById(id).get();
            product.setName(name);
            product.setPrice(price);
            productRepository.save(product);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return "id: " + id + " Cannot update because id not Found\n" + "STACK\n" + e;
        }
    }

    @DeleteMapping("/delete")
    public Object deleteProduct(@RequestParam Long id) {
        try {
            productRepository.deleteById(id);
            return "Product Deleted";
        } catch (Exception e) {
            return "id: " + id + " Cannot delte because id not Found\n" + "STACK\n" + e;
        }
    }
}
