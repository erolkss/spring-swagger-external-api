package br.com.ero.fakeapi.insfrastructure.repositories;

import br.com.ero.fakeapi.insfrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Boolean existsByTitle(String title);
}
