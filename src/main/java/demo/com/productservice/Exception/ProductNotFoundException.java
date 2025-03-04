package demo.com.productservice.Exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {

    }
    public ProductNotFoundException( String message) {
        super(message);
    }
}
