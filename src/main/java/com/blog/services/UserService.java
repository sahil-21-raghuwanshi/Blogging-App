package com.blog.services;

import java.util.List;

import com.blog.playloads.UserDto;

public interface UserService {
  
	 UserDto createUser(UserDto user);
	 UserDto updateUser(UserDto user,Integer userId);
	 UserDto getUserId(Integer userId);
	 List<UserDto> getAllUsers();
	 void deleteUser(Integer userId);
}
