package com.calla.doctor.business.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ConfigClass.class)
public class BusinessModel {

	public static void main(String[] args) {
		 SpringApplication.run(BusinessModel.class, args);

	}

}
