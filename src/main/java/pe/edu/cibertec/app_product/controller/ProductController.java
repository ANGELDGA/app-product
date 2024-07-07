package pe.edu.cibertec.app_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.app_product.model.Product;
import pe.edu.cibertec.app_product.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8085"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }


    @GetMapping("/findByNamePdt/{namePdt}")
    public  ResponseEntity<Product> findByNamePdt(@PathVariable String namePdt){
        return new ResponseEntity<>(productService.findByNamePdt(namePdt), HttpStatus.OK);
    }

    @Query
    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<Product> findByCategory(String category){
        return new ResponseEntity<>(productService.findByCategory(category), HttpStatus.OK);
    }


    @GetMapping("/findAll/{idProduct}")
    public ResponseEntity<Product> findById(@PathVariable Long idProduct){
        return new ResponseEntity<>(productService.findById(idProduct), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        return new ResponseEntity<>(productService.add(product),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product){
        return new ResponseEntity<>(productService.update(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idProduct}")
    public void delete(@PathVariable Long idProduct){

        productService.delete(idProduct);
    }

}
