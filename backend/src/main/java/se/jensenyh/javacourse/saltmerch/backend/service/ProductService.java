package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }

    public void addProduct(Product p, String category) {
        productRepository.insertProductAndProps(p, category);
    }

    public List<Product> getAllProductsFromCategory(String category) {
        try {
            return productRepository.selectAll(category);
        } catch (Exception t) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong category");
        }

    }

    public Product getProduct(int id) {
        return productRepository.getEntireProduct(id);
    }

}
