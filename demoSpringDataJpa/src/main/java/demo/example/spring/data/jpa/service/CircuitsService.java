package demo.example.spring.data.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.spring.data.jpa.entity.Circuits;
import demo.example.spring.data.jpa.repository.CircuitsRepository;

@Service
public class CircuitsService {

	private CircuitsRepository circuitRepository;

	public List<Circuits> getAllCircuits() {
		return circuitRepository.findAll();
	}
	
	public Circuits getCircuitByName(String name) {
		System.out.println("circuitRepository.getCircuitsByName(name):"+circuitRepository.getCircuitsByName(name));
		return circuitRepository.getCircuitsByName(name);
	}

	@Autowired
	public void setCircuitRepository(CircuitsRepository circuitRepository) {
		this.circuitRepository = circuitRepository;
	}
}
