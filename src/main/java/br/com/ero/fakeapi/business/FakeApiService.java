package br.com.ero.fakeapi.business;


import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.insfrastructure.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient fakeApiClient;

    public List<ProductDTO> getProducts(){
        return fakeApiClient.getListProducts();
    }
}
