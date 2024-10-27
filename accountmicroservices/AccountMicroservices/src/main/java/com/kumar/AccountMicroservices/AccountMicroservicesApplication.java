package com.kumar.AccountMicroservices;

import com.kumar.AccountMicroservices.Dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties(value = AccountContactInfoDto.class)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = " Accounts Microservice REST-API Documentation ",
                description = " EasyBanks Account Microservices REST-API Documentation ",
                version = "V1",
                contact = @Contact(
                        name = "Lalu Kumar Rai",
                        email = "lalu11rai@gmail.com",
                        url = "www.eazybank.com"
                ),
                license = @License(
                        name = "Apache 3.0",
                        url = "www.eazybank.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBanks Account Microservices REST-API Documentation",
                url = "www.swagger-ui/index.html"
        )
)
public class AccountMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountMicroservicesApplication.class, args);
    }

}
