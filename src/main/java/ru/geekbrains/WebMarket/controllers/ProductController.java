package ru.geekbrains.WebMarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.WebMarket.model.Product;
import ru.geekbrains.WebMarket.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET > http://localhost:8189/market/products
    @GetMapping("/products")
    public List<Product> showProductsList(){
        return productService.findAll();
    }

    // GET > http://localhost:8189/market/product/{id}
//    @GetMapping("/product/{id}")
//    public String showProduct(Model model, @PathVariable Long id){
//        model.addAttribute("product", productService.findById(id));
//        return "product_info.html";
//    }

    @GetMapping("/product/{productId}")
    public Product showProduct(@PathVariable Long productId){
        return productService.findById(productId);
    }

//    @GetMapping("/create")
//    public String showCreateForm(){
//        return "create_product.html";
//    }

    @GetMapping("/create")
    public void saveProduct(@RequestParam Long productId, @RequestParam String productTitle, @RequestParam float productPrice){
        Product product = new Product(productId, productTitle, productPrice);
        productService.saveProduct(product);
    }

    @GetMapping("/deleteProduct/json/{productId}")
    public boolean deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }

    @GetMapping("/product/changePrice")
    public void changePrice(@RequestParam Long productId, @RequestParam float delta ){
        productService.changePrice(productId, delta);
    }
}
