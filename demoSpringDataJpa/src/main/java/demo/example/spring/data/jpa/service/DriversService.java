package demo.example.spring.data.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.example.spring.data.jpa.entity.Drivers;
import demo.example.spring.data.jpa.repository.DriversRepository;

@Service
public class DriversService {

	@Autowired
	public DriversRepository driversRepository;

	public List<Drivers> getDriversByNationality(String nationality) {
		return driversRepository.findByNationality(nationality);
	}

	public List<Drivers> getDriversByFirstNameStartsWith(String forenameStartsWith) {
		return driversRepository.findByForenameStartsWith(forenameStartsWith);
	}

	public List<Drivers> getDriversByYearOfDob(int year) {
		return driversRepository.findDriversByYearOfDob(year);
	}

	public Page<Drivers> getDriversAscending(Pageable pageable) {
		return driversRepository.findAll(pageable);
	}

	public List<Drivers> getDriversWithFirstNameLike(String likeString) {
		Drivers drivers = new Drivers();
		drivers.setForename(likeString);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("forename",
				match -> match.contains().ignoreCase());
		return driversRepository.findAll(Example.of(drivers, matcher));
	}
}
