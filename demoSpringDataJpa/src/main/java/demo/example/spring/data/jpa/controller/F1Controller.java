package demo.example.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.example.spring.data.jpa.entity.Circuits;
import demo.example.spring.data.jpa.entity.Races;
import demo.example.spring.data.jpa.repository.RacesRepository;
import demo.example.spring.data.jpa.service.CircuitsService;

@RestController
@RequestMapping("/api/f1/")
public class F1Controller {

	@Autowired
	private RacesRepository racesRepository;
	private CircuitsService circuitsService;

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

	@Autowired
	public void setCircuitsService(CircuitsService circuitsService) {
		this.circuitsService = circuitsService;
	}
}
