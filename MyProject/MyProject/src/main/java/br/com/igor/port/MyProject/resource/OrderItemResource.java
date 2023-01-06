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

import br.com.igor.port.MyProject.entities.Order;
import br.com.igor.port.MyProject.entities.OrderItem;
import br.com.igor.port.MyProject.repository.OrderItemRepository;
import br.com.igor.port.MyProject.repository.OrderRepository;

@RestController
@RequestMapping(value = "/OrdemItem")
public class OrderItemResource {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

  

   

    @PostMapping("/OrderItemCreate")
    public Object createProduct(OrderItem orderItem,Long oderIId) {
        try {
           
            Order o = null;
            try {
                 o = orderRepository.findById(oderIId).get();
                
            } catch (Exception e) {
                return "Cannot create Order because is null \n" + e;
            }

            orderItem.setOrder(o);

            orderItem.setPrice(orderItem.getProduct().getPrice() * orderItem.getQuantity());

            orderItemRepository.save(orderItem);
            return "The OrderItem id:  " 
            + orderItem.getId() 
            + " Price  " + orderItem.getPrice() 
            +" Quantity: "
            + orderItem.getQuantity()
            + " Order_Id: "
            + orderItem.getOrder().getId()
            +" Product Id: "
            + orderItem.getProduct().getId()
            +" was successfully created"
            ;

        } catch (Exception e) {
            return "Cannot create OrderItem because need more parameters\n" + e;
        }

    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        return ResponseEntity.ok().body(orderItemList);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            OrderItem orderItem = orderItemRepository.findById(id).get();
            return ResponseEntity.ok().body(orderItem);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Not Found");
        }
    }

    @PutMapping("/update")
    public Object updateProduct(
    @RequestParam Long id, 
    OrderItem orderItem) {

        try {
            OrderItem orderItemup = orderItemRepository.findById(id).get();
            orderItemup.setPrice(orderItem.getPrice());
            orderItemup.setOrder(orderItem.getOrder());
            orderItemup.setProduct(orderItem.getProduct());
            orderItemup.setQuantity(orderItem.getQuantity());
            orderItemRepository.save(orderItemup);
            return orderItemup;
        } catch (Exception e) {
            e.printStackTrace();
            return "id: " + id + " Cannot update because id not Found\n" + "STACK\n" + e;
        }
    }

    @DeleteMapping("/delete")
    public Object deleteProduct(@RequestParam Long id) {
        try {
            orderItemRepository.deleteById(id);
            return "Product Deleted";
        } catch (Exception e) {
            return "id: " + id + " Cannot delte because id not Found\n" + "STACK\n" + e;
        }
    }

    
    
}
