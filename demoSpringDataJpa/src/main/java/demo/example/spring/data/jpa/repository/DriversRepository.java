package demo.example.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.example.spring.data.jpa.entity.Drivers;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long> {
	public List<Drivers> findByForenameStartsWith(String forenameLike);

	public List<Drivers> findByNationality(String nationality);

	@Query(value = "select * from drivers where year(dob)=?1", nativeQuery = true)
	public List<Drivers> findDriversByYearOfDob(int year);
}
