package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class exampleControl {
	@RequestMapping("/")
	public String Index(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formatDate = dateFormat.format(date);
		model.addAttribute("serverTime",formatDate);
		return "Index";

	}
	
//	@RequestMapping("/hello")
//	public String test() {
//		return "helloworld";
//	}
}
