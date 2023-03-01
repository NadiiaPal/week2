package com.example.demo;

import org.example.Manipulations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value="/index")
	public String hi(Model model){
		model.addAttribute("chars", "");
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String returnChars(Model model, @RequestParam("string") String str){
		String strOfChars = "";
		Character[] chrs = Manipulations.fillListCharacters(new String[]{str});

		for (char temp: chrs) {
			strOfChars += temp + " ";
		}

		model.addAttribute("chars", strOfChars);
		return "index";
	}

}


