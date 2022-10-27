package io.knoldus.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JacksonHandle;
import com.marklogic.client.io.StringHandle;
import io.knoldus.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * The type Product repository.
 */
@Repository
public class ProductRepository {

    /**
     * The Json document manager.
     */
    @Autowired
    protected JSONDocumentManager jsonDocumentManager;

    /**
     * Add.
     *
     * @param product the product
     */
    public void add(Product product) {
        DocumentMetadataHandle metadataHandle = new DocumentMetadataHandle();
        metadataHandle.getCollections().add("/products.json");

        JacksonHandle jacksonHandle = new JacksonHandle();
        JsonNode jsonNode = jacksonHandle.getMapper().convertValue(product, JsonNode.class);
        jacksonHandle.set(jsonNode);

        StringHandle stringHandle = new StringHandle(jsonNode.toString());
        jsonDocumentManager.write(getProductId(product.getProductId()), metadataHandle, stringHandle);
    }

    /**
     * Delete.
     *
     * @param productId the product id
     */
    public void delete(Long productId) {
        jsonDocumentManager.delete(getProductId(productId));
    }

    /**
     * Find by product id product.
     *
     * @param productId the product id
     * @return the product
     */
    public Product findByProductId(Long productId) {
        JacksonHandle jacksonHandle = new JacksonHandle();
        jsonDocumentManager.read(getProductId(productId), jacksonHandle);
        return fetchProduct(jacksonHandle);
    }

    private Product fetchProduct(JacksonHandle jacksonHandle) {
        try {
            JsonNode jsonNode = jacksonHandle.get();
            return jacksonHandle.getMapper().readValue(jsonNode.toString(), Product.class);
        } catch (IOException ioException) {
            throw new RuntimeException("Unable to cast to product", ioException);
        }
    }

    private String getProductId(Long productId) {
        return String.format("/products/%d.json", productId);
    }
}
