package com.vn.employeeService.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee API Specification",
                description = "API documentation for Employee Service",
                version = "1.0",
                contact = @Contact(
                        name = "Trinh Quang Lam",
                        email = "trinhquanglam2k4@gmail.com"
                ),
                license = @License(
                        name = "MIT License"
                )
        ),
        servers = @Server(
                description = "Local ENV",
                url = "http://localhost:9002"
        )
)
public class OpenAPIConfig {
}
