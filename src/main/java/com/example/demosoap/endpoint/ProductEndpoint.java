package com.example.demosoap.endpoint;

// Importaciones necesarias para la configuración del endpoint y la conversión de datos
import com.example.demosoap.converter.ProductConverter;
import com.example.demosoap.gen.*;
import com.example.demosoap.model.ProductModel;
import com.example.demosoap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

// Marca esta clase como un endpoint de servicio web SOAP
@Endpoint
public class ProductEndpoint {

    // Define el espacio de nombres utilizado en el servicio web
    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";

    // Inyección de dependencias para el repositorio de productos
    @Autowired
    private ProductRepository productRepository;

    // Inyección de dependencias para el conversor de productos
    @Autowired
    private ProductConverter productConverter;

    // Método que maneja las solicitudes de 'getProductRequest'
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        // Crea una respuesta para la solicitud de producto
        GetProductResponse response = new GetProductResponse();
        // Busca el producto por nombre en el repositorio
        ProductModel productModel = productRepository.findByName(request.getName());
        // Convierte el modelo de producto a producto y lo establece en la respuesta
        response.setProduct(productConverter.convertProductModelToProduct(productModel));
        return response;
    }

    // Método que maneja las solicitudes de 'getProductsRequest'
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
        // Crea una respuesta para la solicitud de productos
        GetProductsResponse response = new GetProductsResponse();
        // Obtiene todos los productos del repositorio
        List<ProductModel> productModels = productRepository.findAll();
        // Convierte los modelos de productos a productos
        List<Product> products = productConverter.convertProductModelsToProducts(productModels);
        // Agrega todos los productos a la respuesta
        response.getProducts().addAll(products);
        return response;
    }

    // Método que maneja las solicitudes de 'postProductRequest'
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse postProducts(@RequestPayload PostProductRequest request) {
        // Crea una respuesta para la solicitud de publicación de producto
        PostProductResponse response = new PostProductResponse();
        // Convierte el producto de la solicitud a un modelo de producto
        ProductModel productModel = productConverter.convertProductToProductModel(request.getProduct());
        // Guarda el modelo de producto en el repositorio y convierte el modelo guardado a producto
        Product product = productConverter.convertProductModelToProduct(productRepository.save(productModel));
        // Establece el producto en la respuesta
        response.setProduct(product);
        return response;
    }

    // Método que maneja las solicitudes de 'updateProductRequest'
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    @ResponsePayload
    public UpdateProductResponse updateProduct(@RequestPayload UpdateProductRequest request) {
        // Crea una respuesta para la solicitud de actualización de producto
        UpdateProductResponse response = new UpdateProductResponse();
        // Convierte el producto de la solicitud a un modelo de producto
        ProductModel productModel = productConverter.convertProductToProductModel(request.getProduct());
        // Guarda el modelo de producto actualizado en el repositorio y convierte el modelo guardado a producto
        Product updatedProduct = productConverter.convertProductModelToProduct(productRepository.save(productModel));
        // Establece el producto actualizado en la respuesta
        response.setProduct(updatedProduct);
        return response;
    }

    // Método que maneja las solicitudes de 'deleteProductRequest'
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    public DeleteProductResponse deleteProduct(@RequestPayload DeleteProductRequest request) {
        // Crea una respuesta para la solicitud de eliminación de producto
        DeleteProductResponse response = new DeleteProductResponse();
        // Elimina el producto del repositorio
        productRepository.deleteById(request.getId());
        // Establece el mensaje de confirmación en la respuesta
        response.setStatus("Product deleted successfully");
        return response;
    }
}
