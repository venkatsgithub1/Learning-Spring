package demo.example.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.example.spring.data.jpa.entity.Circuits;

@Repository
public interface CircuitsRepository extends JpaRepository<Circuits, Long> {
	public Circuits getCircuitsByName(String name);
}
