package com.personal.venture.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.venture.bean.Resident;
import com.personal.venture.exceptions.UserNotFoundException;
import com.personal.venture.repository.ResidentRepository;

@Service
public class ResidentService {

	@Autowired
	private ResidentRepository residentRepository;

	public Resident getResidentById(Integer id) throws UserNotFoundException {
		Optional<Resident> resident = residentRepository.findById(id);
		if (!resident.isPresent()) {
			throw new UserNotFoundException();
		}
		return resident.get();
	}

	public List<Resident> getResidents() {
		List<Resident> residents = new ArrayList<Resident>();
		Iterable<Resident> databaseResidents = residentRepository.findAll();
		Iterator<Resident> residentIt = databaseResidents.iterator();
		while (residentIt.hasNext()) {
			residents.add(residentIt.next());
		}
		return residents;
	}

	public void deleteResident(Integer id) {
		residentRepository.deleteById(id);
	}

	public Resident createResident(Resident resident) {
		return residentRepository.save(resident);
	}

	public Resident updateResident(Resident resident) throws UserNotFoundException {
		boolean isExists = residentRepository.existsById(resident.getId());
		if (!isExists) {
			throw new UserNotFoundException();
		}
		return residentRepository.save(resident);
	}
}
