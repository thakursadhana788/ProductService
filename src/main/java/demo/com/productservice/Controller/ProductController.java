package demo.com.productservice.Controller;

import demo.com.productservice.Model.Product;
import demo.com.productservice.Service.FakeStoreProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final FakeStoreProductService productService;

    public ProductController(FakeStoreProductService inputService) {
        this.productService = inputService;
    }

    @GetMapping("/{id}")
    // this will help the http Get method to fetch all products using specific id
    public Product getProductById(@PathVariable("id") Integer id){ //PathVariable

        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public void createProduct(){

    }

    @DeleteMapping
    public void deleteProduct(){

    }

    @PutMapping("/{id}")
    public void updateProduct( @PathVariable("id") Integer id){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){}


}
