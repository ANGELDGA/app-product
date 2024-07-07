package pe.edu.cibertec.app_product.service;

import pe.edu.cibertec.app_product.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long idProduct);
    public Product findByNamePdt(String namePdt);
    public Product findByCategory(String category);
    public Product add(Product product);
    public Product update(Product product);
    public void delete(Long idProduct);
}
