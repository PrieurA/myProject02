package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@RequestMapping("/doctor/{tag}")
	@ResponseBody
	public String index(@PathVariable int tag) {
		if(tag >=1 && tag <= 8){
			throw new ResponseStatusException(HttpStatus.SEE_OTHER);
		}
		else if(tag == 9) {
			return "number: 9 , name: Christopher Eccleston";
		}
		else if(tag == 10) {
			return "number: 10 , name: David Tennant";
		}
		else if(tag == 11) {
			return "number: 11 , name: Matt Smith";
		}
		else if(tag == 12) {
			return "number: 12 , name: Peter Capaldi";
		}
		else if(tag == 13) {
			return "number: 13 , name: Jodie Whittaker";
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + tag);
	}
}