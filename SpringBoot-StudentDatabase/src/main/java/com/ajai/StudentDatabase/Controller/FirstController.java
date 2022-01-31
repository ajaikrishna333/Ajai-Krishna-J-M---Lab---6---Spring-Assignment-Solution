package com.ajai.StudentDatabase.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@GetMapping("/")
	public String firstApi() {
		return ("<h1>LOGIN SUCCESSFUL !!!</h1> <h2>Please access Swagger UI to access the API's </h2>");
	}

}
