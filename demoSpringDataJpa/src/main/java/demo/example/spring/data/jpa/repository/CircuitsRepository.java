package demo.example.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.example.spring.data.jpa.entity.Circuits;

@Repository
public interface CircuitsRepository extends JpaRepository<Circuits, Long> {
	/*
	 * Abstract method has query defined using @NamedQuery
	 * annotation.
	 */
	public Circuits getCircuitsByName(String name);
	
	/*
	 * Below method doesn't have query written anywhere either in entity or here
	 * using @Query. Spring Data JPA figured out by name of the method.
	 */
	public List<Circuits> findCircuitsByCountry(String country);
}
