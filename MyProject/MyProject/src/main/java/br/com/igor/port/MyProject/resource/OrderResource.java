package br.com.igor.port.MyProject.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.port.MyProject.entities.Order;
import br.com.igor.port.MyProject.repository.OrderRepository;

@RestController
@RequestMapping(value = "/Order")
public class OrderResource {

    @Autowired
    OrderRepository orderRepository;


    @PostMapping("/OrderCreate")
    public String createOrder(Order order) {
        try {
            order.setMoment(LocalDate.now());
            orderRepository.save(order);
            return "the Order " + " Id " + order.getId() + " was successfully created";

        } catch (Exception e) {
            return "Cannot create Order \n" + e;
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return ResponseEntity.ok().body(orderList);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Order order = orderRepository.findById(id).get();
            return ResponseEntity.ok().body(order);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Not Found");
        }
    }



    @DeleteMapping("/delete")
    public Object deleteProduct(@RequestParam Long id) {
        try {
            orderRepository.deleteById(id);
            return "Order Deleted";
        } catch (Exception e) {
            return "id: " + id + " Cannot delte because id not Found\n" + "STACK\n" + e;
        }
    }


}

    
