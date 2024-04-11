package br.com.ero.fakeapi.business.services;


import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.business.converter.ProductConverter;
import br.com.ero.fakeapi.insfrastructure.clients.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient fakeApiClient;
    private final ProductConverter productConverter;
    private final ProductService productService;

    public List<ProductDTO> getProducts() {
        try {
            List<ProductDTO> dto = fakeApiClient.getListProducts();
            dto.forEach(product -> {
                Boolean returnExists = productService.existsByTitle(product.getTitle());
                if (returnExists.equals(false)) {
                    productService.saveProducts(productConverter.toEntity(product));
                }
            });
            return productService.getAllProducts();
        } catch (Exception ex) {
            throw new RuntimeException("Error returning and saving products in the database.");
        }
    }
}
