package pe.edu.cibertec.app_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.app_product.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    Product findByNamePdt(String namePdt);
    Product findByCategory(String category);
}
