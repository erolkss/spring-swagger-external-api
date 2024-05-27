package br.com.ero.fakeapi.apiv1;

import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.business.services.FakeApiService;
import br.com.ero.fakeapi.business.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService fakeApiService;
    private final ProductService productService;


    @Operation(summary = "Save products from API.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save products successfully."),
            @ApiResponse(responseCode = "500", description = "Error save products.")
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductDTO>> saveProductsApi() {
        return ResponseEntity.ok(fakeApiService.getProducts());
    }

    @Operation(summary = "Save new Products.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Product successfully."),
            @ApiResponse(responseCode = "500", description = "Error save product.")
    })
    @PostMapping("/")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.saveProductsDto(productDTO));
    }


    @Operation(summary = "Update new Products.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Product successfully."),
            @ApiResponse(responseCode = "500", description = "Error save product.")
    })
    @PutMapping("/")
    public ResponseEntity<ProductDTO> updateProduct(@RequestParam("id") String id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    @Operation(summary = "Delete product.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save Product successfully."),
            @ApiResponse(responseCode = "500", description = "Error save product.")
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProduct(@RequestParam("title") String title) {
        productService.deleteProduct(title);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Get all products registered.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all products."),
            @ApiResponse(responseCode = "500", description = "Error return products.")
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Get product by name.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return product by name."),
            @ApiResponse(responseCode = "500", description = "Error return product by name.")
    })
    @GetMapping("/{title}")
    public ResponseEntity<ProductDTO> getProductByTitle(@PathVariable String title) {
        return ResponseEntity.ok(productService.getProductByTitle(title));
    }
}
