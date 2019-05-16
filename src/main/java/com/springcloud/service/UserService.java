package com.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.enitity.User;

@FeignClient("eureka-provider")
public interface UserService {
    @RequestMapping(value="/user/getusers",method = RequestMethod.POST)
	public List<User> getUsers();
	@RequestMapping(value="/user/adduser",method = RequestMethod.POST)
	public User addUser(User user);
}
