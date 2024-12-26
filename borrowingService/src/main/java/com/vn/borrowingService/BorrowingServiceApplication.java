package com.vn.borrowingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.vn.borrowingService","com.vn.commonService"})
public class BorrowingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingServiceApplication.class, args);
	}

}
