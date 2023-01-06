package br.com.igor.port.MyProject.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate moment;

    @OneToMany(mappedBy = "orderI")
    private List<OrderItem> items = new ArrayList<>();
    

    @OneToOne()
    @JoinColumn(nullable = false )
    private OrderStatus orderStatus;

    @OneToOne
    @JoinColumn(nullable = false )
    private Client client;

    

    public Order(OrderStatus orderStatus, Client client) {
        this.moment = LocalDate.now();
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Order(){}

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }
  

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    



    
    
}
