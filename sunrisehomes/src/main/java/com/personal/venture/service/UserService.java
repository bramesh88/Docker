package com.personal.venture.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.venture.bean.User;
import com.personal.venture.exceptions.UserNotFoundException;
import com.personal.venture.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(Integer id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Iterable<User> databaseUsers = userRepository.findAll();
		Iterator<User> userIt = databaseUsers.iterator();
		while (userIt.hasNext()) {
			users.add(userIt.next());
		}
		return users;
	}

	public void deleteUsers(Integer id) {
		userRepository.deleteById(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) throws UserNotFoundException {
		boolean isExists = userRepository.existsById(user.getId());
		if (!isExists) {
			throw new UserNotFoundException();
		}
		return userRepository.save(user);
	}
}
