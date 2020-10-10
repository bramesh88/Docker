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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.venture.bean.Resident;
import com.personal.venture.exceptions.UserNotFoundException;
import com.personal.venture.service.ResidentService;

@RestController
public class ResidentResource {

	@Autowired
	private ResidentService residentService;

	@GetMapping("/residents/{id}")
	public ResponseEntity<Resident> getResidentById(@PathVariable int id) {
		System.out.println("Resident Id");
		Resident resident = null;
		try {
			resident = residentService.getResidentById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resident>(resident, HttpStatus.OK);
	}

	@PutMapping("/residents")
	public ResponseEntity<Object> updateResident(@RequestBody Resident resident) {
		System.out.println("Resident create");
		try {
			resident = residentService.updateResident(resident);
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/residents")
	public ResponseEntity<Object> createResident(@RequestBody Resident resident) {
		System.out.println("Resident create");
		Resident residentObject = residentService.createResident(resident);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(residentObject.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/residents")
	public ResponseEntity<List<Resident>> getResidents() {
		System.out.println("Resident create");
		List<Resident> residents = residentService.getResidents();
		return new ResponseEntity<List<Resident>>(residents, HttpStatus.OK);
	}

	@DeleteMapping("/residents/{id}")
	public void getResidents(@PathVariable("id") int id) {
		System.out.println("Resident getResidents");
		residentService.deleteResident(id);
	}

}
