package br.com.ero.fakeapi.business.services;

import br.com.ero.fakeapi.insfrastructure.entities.ProductEntity;
import br.com.ero.fakeapi.insfrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity saveProducts(ProductEntity product) {
        try {
            return productRepository.save(product);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving products " + ex);
        }
    }

    public List<ProductEntity> getAllProducts() {
        try {
            return productRepository.findAll();

        } catch (Exception ex) {
            throw new RuntimeException("Error returning all products");
        }
    }

    public Boolean existsByTitle(String title) {
        try {
            return productRepository.existsByTitle(title);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error returning product by title.", title), ex);
        }
    }
}
