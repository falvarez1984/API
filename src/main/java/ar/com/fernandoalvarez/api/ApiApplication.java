package ar.com.fernandoalvarez.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "BearerAuthentication";

        return new OpenAPI().info(new Info().title("API").version("v1.0.0")
                .description("Proyecto API")
                .contact(new Contact().name("Fernando Alvarez").email("alvarezfernandonicolas@gmail.com")));
    }

}
