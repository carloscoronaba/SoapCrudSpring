package com.example.demosoap.model;

// Importaciones necesarias para la definición de la entidad y el uso de Lombok
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// Marca esta clase como una entidad JPA
@Entity
// Anotación de Lombok que genera automáticamente getters, setters, toString, equals, y hashCode
@Data
public class ProductModel {

    // Marca este campo como la clave primaria de la entidad
    @Id
    // Especifica que el valor del ID se generará automáticamente
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Identificador único del producto

    private String name; // Nombre del producto
    private double price; // Precio del producto
    private String description; // Descripción del producto
}
