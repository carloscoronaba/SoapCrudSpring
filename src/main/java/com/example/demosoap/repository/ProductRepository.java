package com.example.demosoap.repository;

// Importación necesaria para el uso de JPA y la definición del repositorio
import com.example.demosoap.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Marca esta interfaz como un repositorio Spring
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    // Método personalizado para encontrar un producto por su nombre
    ProductModel findByName(String name);
}
