package br.com.ero.fakeapi.insfrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ProductEntity")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title", length = 800)
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category", length = 800)
    private String category;
    @Column(name = "description", length = 800)
    private String description;
    @Column(name = "image", length = 800)
    private String image;
    @Column(name = "date_inclusion")
    private LocalDateTime dateInclusion;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
}
