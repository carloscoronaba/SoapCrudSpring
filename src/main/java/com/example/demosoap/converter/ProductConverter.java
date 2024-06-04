package com.example.demosoap.converter;

// Importaciones necesarias para la conversión entre Product y ProductModel
import com.example.demosoap.gen.Product;
import com.example.demosoap.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Marca esta clase como un componente Spring para permitir la inyección de dependencias
@Component
public class ProductConverter {

    // Convierte un objeto Product a ProductModel
    public ProductModel convertProductToProductModel(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId()); // Asigna el ID del producto
        productModel.setName(product.getName()); // Asigna el nombre del producto
        productModel.setPrice(product.getPrice()); // Asigna el precio del producto
        productModel.setDescription(product.getDescription()); // Asigna la descripción del producto
        return productModel;
    }

    // Convierte un objeto ProductModel a Product
    public Product convertProductModelToProduct(ProductModel productModel) {
        Product product = new Product();
        product.setId(productModel.getId()); // Asigna el ID del modelo de producto
        product.setName(productModel.getName()); // Asigna el nombre del modelo de producto
        product.setPrice(productModel.getPrice()); // Asigna el precio del modelo de producto
        product.setDescription(productModel.getDescription()); // Asigna la descripción del modelo de producto
        return product;
    }

    // Convierte una lista de objetos Product a una lista de ProductModel
    public List<ProductModel> convertProductsToProductModels(List<Product> products) {
        List<ProductModel> productModels = new ArrayList<>();
        for (Product product : products) {
            productModels.add(convertProductToProductModel(product)); // Convierte cada producto y lo agrega a la lista
        }
        return productModels;
    }

    // Convierte una lista de objetos ProductModel a una lista de Product
    public List<Product> convertProductModelsToProducts(List<ProductModel> productModels) {
        List<Product> products = new ArrayList<>();
        for (ProductModel productModel : productModels) {
            products.add(convertProductModelToProduct(productModel)); // Convierte cada modelo de producto y lo agrega a la lista
        }
        return products;
    }
}
