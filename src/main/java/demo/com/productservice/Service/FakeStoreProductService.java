package demo.com.productservice.Service;


import demo.com.productservice.DTO.FakeStoreResponseDTO;
import demo.com.productservice.Model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import demo.com.productservice.Model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(Integer id ){
        Product product = new Product();
        //1.call fake store API
        //1.1using RestTemplate
        ResponseEntity<FakeStoreResponseDTO> FakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/"+ id, FakeStoreResponseDTO.class);
        // 2. Get the response
        FakeStoreResponseDTO response = FakeStoreResponse.getBody();
        System.out.println(response);
        // 3.Convert the response to product model
        product=convertToProduct(response);
        return product;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        ResponseEntity<FakeStoreResponseDTO[]> FakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);
        FakeStoreResponseDTO[] response = FakeStoreResponse.getBody();
        for(FakeStoreResponseDTO fakeStoreResponseDTO : response){
            Product product = convertToProduct(fakeStoreResponseDTO);
            products.add(product);
        }
        return products;
    }


    private Product convertToProduct(FakeStoreResponseDTO response) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(response.getCategory());

        product.setId(response.getId());
        product.setCategory(category);
        product.setDescription(response.getDescription());
        product.setImage(response.getImage());
        product.setName(response.getTitle());

        return product;

    }
}
