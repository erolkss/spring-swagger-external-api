package br.com.ero.fakeapi.apiv1;

import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.business.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService fakeApiService;


    @Operation(summary = "Search for all products.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search successfully."),
            @ApiResponse(responseCode = "500", description = "Error when searching for data.")
    })
    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return ResponseEntity.ok(fakeApiService.getProducts());
    }

}
