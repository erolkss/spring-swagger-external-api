package br.com.ero.fakeapi.apiv1.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Boot 3, Fake Store API, Swagger")
                                .description("Using Feign Client to consume an External API. Using the MySQL Database with a simple CRUD and optimizing the data structure using DTO's.\n" +
                                        "Integrating Swagger into Spring Boot to document the API clearly and concisely. Making it easier for other developers to understand and use your API.")
                                .version("v1")
                                .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                                .contact(new Contact().name("Lucas Eduardo Lima").email("lucaserolima@gmail.com"))
                );
    }
}
