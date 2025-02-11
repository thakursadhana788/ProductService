package demo.com.productservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    // for RestTemplate we cant just create object using @ because we don't own this class this is the way to create
    //object now spring boot will create this for us
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
