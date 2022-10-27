package io.knoldus.service;

import io.knoldus.entity.Product;
import io.knoldus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Find by product id product.
     *
     * @param productId the product id
     * @return the product
     */
    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }

    /**
     * Add.
     *
     * @param product the product
     */
    public void add(Product product) {
        productRepository.add(product);
    }

    /**
     * Delete.
     *
     * @param productId the product id
     */
    public void delete(Long productId) {
        productRepository.delete(productId);
    }
}
