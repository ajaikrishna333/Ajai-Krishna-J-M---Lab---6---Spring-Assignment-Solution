package com.ajai.StudentDatabase;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.ajai.StudentDatabase.DaoLayer.StudentRepository;
import com.ajai.StudentDatabase.Entity.Student;
import com.ajai.StudentDatabase.Entity.Role;
import com.ajai.StudentDatabase.Entity.User;
import com.ajai.StudentDatabase.Service.StudentService;
	
@SpringBootApplication
public class SpringBootStudentDatabaseApplication implements CommandLineRunner {
	
//	@Autowired
//	EmployeeService employeeService;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentDatabaseApplication.class, args);
		
	}
	
	
	@Override
	public void run(String... args) throws Exception {
	
		
	}

}
