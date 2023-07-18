package com.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.playloads.ApiResponse;
import com.blog.playloads.UserDto;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired  
	private UserService userservice;
	
	//post -create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createUserDto =this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	//get  -fatch user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		return ResponseEntity.ok(this.userservice.getAllUsers());
	}
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userid") Integer userid)
	{
		return ResponseEntity.ok(this.userservice.getUserId(userid));
	}
	//put -update user
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,	@PathVariable("userid") Integer userid)
	{
		UserDto updateUserDto =this.userservice.updateUser(userDto,userid);
		return ResponseEntity.ok(updateUserDto);
	}
	//DELETE delete user
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userid") Integer userid)
	{
		this.userservice.deleteUser(userid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted ", true) ,HttpStatus.OK);
	}
     
}
