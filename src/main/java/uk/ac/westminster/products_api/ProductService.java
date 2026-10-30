package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;


    // takes no parameters and returns the whole list
    public List<Product> getAllProducts() { //you haven't sent any POST requests to add products yet
        return products;
    }


    // sets the id, adds to the list, and returns the product
    public Product addProduct(Product product) {

        // that uses  the current value and then increments it,
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()  // makes the Products list into a sequence
                // stream --> search and process lists without messy for loops
                // like a conveyor belt
                .filter(p -> p.getId().equals(id)) // filter: a security guard next to conveyor belt
                // p --> to temporarily store currently passing Product
                // -> : "goes to or" takes this item and test this against this rule
                //If it returns true: The guard keeps the product on the belt.
                //If it returns false: The guard removes the product from the belt.
                .findFirst(); // and hand back the very first match u find
    }


    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id)); // products is the array list
        // removeIf : This is a built-in Java method for collections.
        // It automatically loops through the entire list and deletes any item that matches the condition you give it inside the parentheses.

        // p -> p.getId().equals(id) : This is a lambda expression
        //p: Represents each individual product in the list as Java loops through them one by one.
        // p.getId(): Gets the ID of that specific product.
        //.equals(id): Compares that product's ID with the id passed into the method.
        //The Result: If the condition evaluates to true (meaning the IDs match), removeIf instantly deletes that product from your list.

    }


    //This code implements a search feature, allowing clients to search for products by their name (e.g., finding all products that contain the word "mouse").
    //It extracts data from the query string at the very end of the URL, which starts with a question mark (?).
    public List<Product> findByName(String name){
        return products.stream()
                .filter(p ->p.getName().contains(name))
                .toList();
    }
}
