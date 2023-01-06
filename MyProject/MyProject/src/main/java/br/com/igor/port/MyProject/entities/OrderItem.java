package br.com.igor.port.MyProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
	@JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Order orderI;


    public Order getOrder() {
        return orderI;
    }


    public void setOrder(Order order) {
        this.orderI = order;
    }



    public OrderItem(Integer quantity, Double price, Product product, Order orderI) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.orderI = orderI;
    }

    public OrderItem(){}

    

    public Product getProduct() {
        return product;
    }



    public void setProduct(Product product) {
        this.product = product;
    }



    public long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    

    
}
