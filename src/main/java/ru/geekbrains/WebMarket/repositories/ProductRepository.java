package ru.geekbrains.WebMarket.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.WebMarket.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(345L, "Хлеб", 45),
                new Product(24L, "Молоко", 70),
                new Product(1903L, "Масло", 200),
                new Product(334L, "Соль", 10),
                new Product(5L, "Яблоки", 100)
        ));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(productList);
    }

    public Product findById(Long id){
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    public void saveProduct(Product product){
        productList.add(product);
    }

    public void deleteProduct(Long id){
        System.out.println("!!!");
        productList.removeIf(product -> product.getId().equals(id));
    }
}
