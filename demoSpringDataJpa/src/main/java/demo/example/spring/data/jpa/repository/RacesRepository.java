package demo.example.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.example.spring.data.jpa.entity.Races;

@Repository
public interface RacesRepository extends JpaRepository<Races, Long> {
	
}
