package com.ajai.StudentDatabase.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig { 
	
	@Bean
	public Docket crmApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("StudentDatabase-Api")
				.select().apis(RequestHandlerSelectors.basePackage("com.ajai.StudentDatabase.Controller"))
				.build();		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee DB - Api")
				.description( "ADMINS CAN ACCESS THE BELOW FUNCTIONS (ALL FUNCTIONS)"+ "\r\n" + "\r\n" +"/saveStudent " + "\r\n" + "/updateStudent" + "\r\n" + "/findStudentById" + "\r\n" + "/findStudentByName" + "\r\n" + "/findAllStudents" + "\r\n" + "/deleteStudentById" 
						+ "\r\n"
						+ "\r\n"
						+"USERS CAN ACCESS THE BELOW FUNCTIONS ONLY"
						+ "\r\n" + "/saveStudent" + "\r\n" + " /findStudentById" + "\r\n" + "/findStudentByName" + "\r\n" + "/findAllStudents")
				.contact(new Contact("CRM-API", "http://fakelibrary.com","jmajaikrishna@gl.com"))
				.license("License")
				.licenseUrl("http://fakelibrary.com")
				.version("1.0")
				.build();
	}
	
}
