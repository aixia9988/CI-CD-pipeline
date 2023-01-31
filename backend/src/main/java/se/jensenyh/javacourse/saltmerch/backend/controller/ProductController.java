package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3010"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/api/v1/products/hats")
    public List<Product> getAllProductsFromHats() {
        return productService.getAllProductsFromCategory("hats");
    }

    @GetMapping("/api/v1/products/jackets")
    public List<Product> getAllProductsFromCategory() {
        return productService.getAllProductsFromCategory("jackets");
    }

    @GetMapping("/api/v1/products/tshirts")
    public List<Product> getAllProductsFromTshrits() {
        return productService.getAllProductsFromCategory("tshirts");
    }

    @GetMapping("/api/v1/products/bags")
    public List<Product> getAllProductsFromBags() {
        return productService.getAllProductsFromCategory("bags");
    }

    @GetMapping("/api/v1/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        try  {
            return productService.getProduct(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cloud not find product by ID");
        }

    }


}






