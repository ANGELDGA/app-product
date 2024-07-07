package pe.edu.cibertec.app_product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_product.model.Product;
import pe.edu.cibertec.app_product.repository.ProductRepository;

import java.util.List;

@Service
public class IProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long idProduct) {
        return productRepository.findById(idProduct).get();
    }

    @Query
    @Override
    public Product findByNamePdt(String namePdt) {
        return productRepository.findByNamePdt(namePdt);
    }

    @Query
    @Override
    public Product findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        var productBD = productRepository.findById(product.getIdProduct()).get();
        productBD.setIdProduct(product.getIdProduct());
        productBD.setNamePdt(product.getNamePdt());
        productBD.setDescription(product.getDescription());
        productBD.setPrice(product.getPrice());
        productBD.setCategory(product.getCategory());
        productBD.setImg(product.getImg());
        productBD.setDiscount(product.getDiscount());
        return productRepository.save(productBD);
    }

    @Override
    public void delete(Long idProduct) {
        var productBD = productRepository.findById(idProduct).get();
        productRepository.delete(productBD);
    }
}
