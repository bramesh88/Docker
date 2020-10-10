package com.personal.venture.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.venture.bean.User;
import com.personal.venture.exceptions.UserNotFoundException;
import com.personal.venture.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> sayHelloResponse() {
		// return "Hi world!!";
		return new ResponseEntity<String>("Hi World", HttpStatus.OK);
	}

	/*
	 * @GetMapping("/swagger/users/{id}") public ResponseEntity<User>
	 * getUserDetails(@PathVariable int id) { System.out.println("User Id"); User
	 * user = null; try { user = userService.getUser(id); } catch
	 * (UserNotFoundException e) { e.printStackTrace(); } Resource<User> resource =
	 * new Resource<User>(user);
	 * 
	 * ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
	 * 
	 * resource.add(linkTo.withRel("all-user"));
	 * 
	 * return resource; }
	 */
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		System.out.println("User Id");
		User user = null;
		try {
			user = userService.getUser(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping("/users")
	public ResponseEntity<Object> getUser(@RequestBody User user) {
		System.out.println("User create");
		try {
			user = userService.updateUser(user);
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		System.out.println("User create");
		User userObject = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userObject.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		System.out.println("User create");
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public void getUsers(@PathVariable("id") int id) {
		System.out.println("User getUsers");
		userService.deleteUsers(id);
	}
}
