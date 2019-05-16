package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springcloud.enitity.User;
import com.springcloud.service.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;
  
  @RequestMapping("/users")
  public String getUser() {
	  List<User> users = userService.getUsers();
	  StringBuffer sb = new StringBuffer();
	  for (User user : users) {
		  Gson gson = new Gson();
		  String jsonStr = gson.toJson(user);
		  sb.append(jsonStr).append("\n");
	  }
	  return sb.toString();
	  
  }
  
  @RequestMapping("/add")
  public String addUser() {
	  User user = new User();
	  user.setName("nayunhao2");
	  user.setAge(32);
	  User u = userService.addUser(user);
	  Gson gson = new Gson();
	  
	  
	  return gson.toJson(u);
  }
}
