package ru.geekbrains.WebMarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.WebMarket.model.Product;
import ru.geekbrains.WebMarket.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET > http://localhost:8189/market/products
    @GetMapping("/products")
    public String showProductsList(Model model){
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }

    // GET > http://localhost:8189/market/product/{id}
    @GetMapping("/product/{id}")
    public String showProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        return "product_info.html";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "create_product.html";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int price){
        Product product = new Product(id, title, price);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete_product/{id}") //Пока не пойму, где ошибка:в методе или во front'е
    public String deleteProduct(@RequestParam Long id){
        System.out.println("!!!!!!!!!");    //Пытаюсь остановит в этой точке, но слетает раньше с ошибкой type=Bad Request, status=400
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
