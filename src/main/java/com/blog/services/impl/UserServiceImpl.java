package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.*;
import com.blog.entities.*;
import com.blog.playloads.UserDto;
import com.blog.repository.UserRepo;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserId(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List <User> users=this.userRepo.findAll();
		List <UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		 
		User user=new User();
		user.setAbout(user.getAbout());
		user.setEmail(user.getEmail());
		user.setId(user.getId());
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		return user;
	}
	public UserDto userToDto(User user)
	{
		UserDto userdto=new UserDto();
		userdto.setEmail(user.getEmail());
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setAbout(user.getAbout());
		userdto.setPassword(user.getPassword());
		return userdto;
	}

}
