package io.knoldus.controller;

import io.knoldus.entity.Product;
import io.knoldus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * The type Product controller.
 */
@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Gets product.
     *
     * @param productId the product id
     * @return the product
     */
    @GetMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") Long productId) {
        return productService.findByProductId(productId);
    }

    /**
     * Create product.
     *
     * @param product           the product
     * @param componentsBuilder the components builder
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Product product, UriComponentsBuilder componentsBuilder) {
        productService.add(product);
    }

    /**
     * Delete product.
     *
     * @param productId the product id
     */
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
    }
}
