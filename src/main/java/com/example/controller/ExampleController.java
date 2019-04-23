package com.example.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.controller.impl.ExampleControllerImpl;

@RestController
@RequestMapping("/users")
public class ExampleController implements ExampleControllerImpl{
//	@RequestMapping("/")
//	public String Index(Locale locale, Model model) {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formatDate = dateFormat.format(date);
//		model.addAttribute("serverTime",formatDate);
//		return "index";
//	}
	
//	@RequestMapping("/")
//	@ResponseBody
//	public User userTest() {
//		User user = new User();
//		user.setName("haha");
//		return user;
//	}
	
//	@RequestMapping("/hello")
//	public String test() {
//		return "helloworld";
//	}
	static Map<Long, User> usersMap = Collections.synchronizedMap(new HashMap<Long ,User>());
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList(){
		List<User> user = new ArrayList<User>(usersMap.values());
		return user;
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		usersMap.put(user.getId(), user);
		return "Success";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return usersMap.get(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user) {
		User renewUser = usersMap.get(id);
		renewUser.setAge(user.getAge());
		renewUser.setName(user.getName());
		usersMap.put(id, renewUser);
		return "success";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleUser(@PathVariable Long id) {
		usersMap.remove(id);
		return "success";
	}
	
}
