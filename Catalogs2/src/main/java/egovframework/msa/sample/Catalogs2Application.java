package egovframework.msa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("egoframework.*")
@SpringBootApplication
@EnableCircuitBreaker
public class Catalogs2Application {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(Catalogs2Application.class, args);
  }

}
