package com.personal.venture.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.venture.bean.ResidentDetails;
import com.personal.venture.exceptions.UserNotFoundException;
import com.personal.venture.repository.ResidentDetailsRepository;

@Service
public class ResidentDetailsService {

	@Autowired
	private ResidentDetailsRepository residentDetailsRepository;

	public ResidentDetails getResidentDetails(Integer id) throws UserNotFoundException {
		Optional<ResidentDetails> resident = residentDetailsRepository.findById(id);
		if (!resident.isPresent()) {
			throw new UserNotFoundException();
		}
		return resident.get();
	}

	public List<ResidentDetails> getAllResidentDetails() {
		List<ResidentDetails> residents = new ArrayList<ResidentDetails>();
		Iterable<ResidentDetails> databaseResidents = residentDetailsRepository.findAll();
		Iterator<ResidentDetails> residentIt = databaseResidents.iterator();
		while (residentIt.hasNext()) {
			residents.add(residentIt.next());
		}
		return residents;
	}

	public void deleteResidentDetails(Integer id) {
		residentDetailsRepository.deleteById(id);
	}

	public ResidentDetails createResident(ResidentDetails resident) {
		return residentDetailsRepository.save(resident);
	}

	public ResidentDetails updateResident(ResidentDetails resident) throws UserNotFoundException {
		boolean isExists = residentDetailsRepository.existsById(resident.getId());
		if (!isExists) {
			throw new UserNotFoundException();
		}
		return residentDetailsRepository.save(resident);
	}
}
