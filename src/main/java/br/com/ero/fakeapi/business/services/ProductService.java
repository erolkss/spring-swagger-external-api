package br.com.ero.fakeapi.business.services;

import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.business.converter.ProductConverter;
import br.com.ero.fakeapi.insfrastructure.entities.ProductEntity;
import br.com.ero.fakeapi.insfrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductEntity saveProducts(ProductEntity product) {
        try {
            return productRepository.save(product);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving products " + ex);
        }
    }

    public ProductDTO saveProductsDto(ProductDTO productDTO) {
        try {
            ProductEntity entity = productConverter.toEntity(productDTO);
            return productConverter.toDto(productRepository.save(entity));
        } catch (Exception ex) {
            throw new RuntimeException("Error saving products " + ex);
        }
    }


    public void deleteProduct(String title) {
        try {
            productRepository.deleteByTitle(title);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error when deleting product.", title), ex);
        }
    }

    public ProductDTO getProductByTitle(String title) {
        try {
            return productConverter.toDto(productRepository.findByTitle(title));
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error returning product by title.", title), ex);
        }
    }

    public List<ProductDTO> getAllProducts() {
        try {
            return productConverter.toListDto(productRepository.findAll());
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error returning list the products."), ex);
        }
    }

    public Boolean existsByTitle(String title) {
        try {
            return productRepository.existsByTitle(title);
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error returning product by title.", title), ex);
        }
    }

    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        try {
            ProductEntity entity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id does not exist in the database."));
            saveProducts(productConverter.toEntityUpdate(id, entity, productDTO));
            return productConverter.toDto(productRepository.findByTitle(entity.getTitle()));
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Error updating product."), ex);
        }
    }
}
