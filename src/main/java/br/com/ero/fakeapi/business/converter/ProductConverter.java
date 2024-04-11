
package br.com.ero.fakeapi.business.converter;

import br.com.ero.fakeapi.apiv1.dto.ProductDTO;
import br.com.ero.fakeapi.insfrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProductConverter {

    public ProductEntity toEntity(ProductDTO productDTO){
        return ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .title(productDTO.getTitle())
                .category(productDTO.getCategory())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .image(productDTO.getImage())
                .dateInclusion(LocalDateTime.now())
                .build();
    }

    public ProductDTO toDto(ProductEntity productEntity){
        return ProductDTO.builder()
                .entityId(productEntity.getId())
                .title(productEntity.getTitle())
                .category(productEntity.getCategory())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .image(productEntity.getImage())
                .build();
    }

    public List<ProductDTO> toListDto(List<ProductEntity> entityList){
        return entityList.stream().map(this::toDto).toList();
    }

}
