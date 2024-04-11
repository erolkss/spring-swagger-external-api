package br.com.ero.fakeapi.insfrastructure.repositories;

import br.com.ero.fakeapi.insfrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Boolean existsByTitle(String title);

    ProductEntity findByTitle(String title);

    @Transactional
    void deleteByTitle(String title);
}
