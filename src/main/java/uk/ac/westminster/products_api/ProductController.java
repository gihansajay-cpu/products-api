package uk.ac.westminster.products_api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController{

    // telling to wire ProductService
    @Autowired
    private ProductService productService; // productService is an instance of ProductService blueprint


    // THIS IS THE CONTROLLER, IT HANDS  WHAT SERVICE GIVES TO THE BROWSER(from return)
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts(); // this returns the whole list to browser... Poostman or swagger UI
                                                // JAVA Objects --> JSON
    }

                                 // this @GetMapping annotation always linked with the method after it
    @GetMapping("/products/{id}")// telling spring boot to get http request comes from this form product/5,and store it in id variable
    public Product getProductById(@PathVariable Long id){ //path variable maps that id to the method
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct (@RequestBody Product  product) { // requestbody convert incoming json to java object
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);

    }

    @GetMapping ("/products/search")
    public List<Product> search(@RequestParam String name){ //For Filtering, Searching, or Options
        return productService.findByName(name);
    }
}