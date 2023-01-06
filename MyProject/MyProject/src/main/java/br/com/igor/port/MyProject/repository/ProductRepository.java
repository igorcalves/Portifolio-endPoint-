package br.com.igor.port.MyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.port.MyProject.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
