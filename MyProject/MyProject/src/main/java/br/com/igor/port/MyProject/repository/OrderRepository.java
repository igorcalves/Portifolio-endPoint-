package br.com.igor.port.MyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.port.MyProject.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
