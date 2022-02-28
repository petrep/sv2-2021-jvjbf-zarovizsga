package webshop;

import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    void saleProduct(long id, int amount) {
        Product actualProduct = productRepository.findProductById(id);
        if(actualProduct.getStock() >= amount) {
            productRepository.updateProductStock(id, amount);
        } else {
            throw new IllegalArgumentException("This product's supply is low !" + id);
        }
    }

}
