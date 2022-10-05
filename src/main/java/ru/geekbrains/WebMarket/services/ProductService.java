package ru.geekbrains.WebMarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.WebMarket.model.Product;
import ru.geekbrains.WebMarket.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id);
    }

    public void saveProduct(Product product){
        productRepository.saveProduct(product);
    }

    public boolean deleteProduct(Long id){
        return productRepository.deleteProduct(id);
    }

    public void changePrice(Long id, float delta){
        Product product = productRepository.findById(id);
        product.setPrice(product.getPrice() + delta);
    }
}
