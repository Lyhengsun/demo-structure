package com.test.demostructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
		info = @Info(
				title = "Test Service API",
				version = "1.0.0",
				description = "Endpoints"
		),
		servers = {
				@Server(url = "/")
		}
)
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", in = SecuritySchemeIn.HEADER)
@SpringBootApplication
@EnableFeignClients
public class DemoStructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStructureApplication.class, args);
    }

}
