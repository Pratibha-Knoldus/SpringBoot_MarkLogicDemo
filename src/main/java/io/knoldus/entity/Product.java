package io.knoldus.entity;

/**
 * The type Product.
 */
public class Product {
    private long productId;
    private String name;
    private String description;
    private Double price;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param Id          the id
     * @param name        the name
     * @param description the description
     * @param price       the price
     */
    public Product(Long Id, String name, String description, Double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }
}
