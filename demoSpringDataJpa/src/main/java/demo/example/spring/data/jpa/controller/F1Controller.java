package demo.example.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.example.spring.data.jpa.entity.Circuits;
import demo.example.spring.data.jpa.entity.Drivers;
import demo.example.spring.data.jpa.entity.Races;
import demo.example.spring.data.jpa.repository.RacesRepository;
import demo.example.spring.data.jpa.service.CircuitsService;
import demo.example.spring.data.jpa.service.DriversService;

@RestController
@RequestMapping("/api/f1/")
public class F1Controller {

	@Autowired
	private RacesRepository racesRepository;
	private CircuitsService circuitsService;

	@Autowired
	private DriversService driversService;

	@GetMapping("/test")
	public String getData() {
		System.out.println(racesRepository.count());
		return "hello";
	}

	@GetMapping("/races")
	public List<Races> getRaces() {
		return racesRepository.findAll();
	}

	@GetMapping("/circuits")
	public List<Circuits> getCircuits() {
		return circuitsService.getAllCircuits();
	}

	@GetMapping("/byCircuit")
	public ResponseEntity<Circuits> getCircuitsByName(@RequestParam(name = "name") String name) {
		System.out.println("in circuits by name");
		Circuits circuit = circuitsService.getCircuitByName(name);

		if (circuit != null) {
			return new ResponseEntity<Circuits>(circuit, HttpStatus.OK);
		}

		return new ResponseEntity<Circuits>(circuit, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/circuitsByCountry")
	public ResponseEntity<List<Circuits>> getCircuitsByCountryName(@RequestParam(name = "country") String countryName) {
		List<Circuits> circuitsList = circuitsService.getCircuitsByCountryName(countryName);

		if (circuitsList != null && circuitsList.size() > 0) {
			return new ResponseEntity<List<Circuits>>(circuitsList, HttpStatus.OK);
		}

		return new ResponseEntity<List<Circuits>>(circuitsList, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/circuitsWithPagenation")
	public ResponseEntity<List<Circuits>> getCircuitsWithPagenation(
			@RequestParam(name = "pageNumber", required = true) int pageNumber,
			@RequestParam(name = "noOfRecordsPerPage") int noOfRecordsPerPage) {
		Page<Circuits> circuitsPage = circuitsService
				.getCircuitsWithPagenation(PageRequest.of(pageNumber, noOfRecordsPerPage));
		if (circuitsPage.hasContent()) {
			return new ResponseEntity<List<Circuits>>(circuitsPage.getContent(), HttpStatus.OK);
		}

		return new ResponseEntity<List<Circuits>>(circuitsPage.getContent(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/driversByNationality")
	public ResponseEntity<List<Drivers>> getDriversByNationality(
			@RequestParam(name = "nationality", required = true) String nationality) {
		List<Drivers> drivers = driversService.getDriversByNationality(nationality);

		if (drivers != null && drivers.size() > 0) {
			return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.OK);
		}

		return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/driversFirstNameStartsWith")
	public ResponseEntity<List<Drivers>> getDriversWithFirstNameStartsWith(
			@RequestParam(name = "startsWith", required = true) String firstNameStartsWith) {
		List<Drivers> drivers = driversService.getDriversByFirstNameStartsWith(firstNameStartsWith);

		if (drivers != null && drivers.size() > 0) {
			return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.OK);
		}

		return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/driversByYearOfDob")
	public ResponseEntity<List<Drivers>> getDriversByYearOfDob(@RequestParam(name = "year", required = true) int year) {
		List<Drivers> drivers = driversService.getDriversByYearOfDob(year);

		if (drivers != null && drivers.size() > 0) {
			return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.OK);
		}

		return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/driversByAge")
	public ResponseEntity<List<Drivers>> getDriversAscending(
			@RequestParam(name = "pageNumber", required = true) int pageNumber,
			@RequestParam(name = "sizeInPage", required = true) int sizeInPage) {
		Page<Drivers> driversPage = driversService
				.getDriversAscending(PageRequest.of(pageNumber, sizeInPage, Sort.Direction.DESC, "dob"));

		if (driversPage.hasContent()) {
			return new ResponseEntity<List<Drivers>>(driversPage.getContent(), HttpStatus.OK);
		}

		return new ResponseEntity<List<Drivers>>(driversPage.getContent(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/driversFirstNameLike")
	public ResponseEntity<List<Drivers>> getDriversWithFirstNameLike(
			@RequestParam(name = "like", required = true) String likeString) {
		List<Drivers> drivers = driversService.getDriversWithFirstNameLike(likeString);

		if (drivers != null && drivers.size() > 0) {
			return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.OK);
		}

		return new ResponseEntity<List<Drivers>>(drivers, HttpStatus.NOT_FOUND);
	}

	@Autowired
	public void setCircuitsService(CircuitsService circuitsService) {
		this.circuitsService = circuitsService;
	}
}
