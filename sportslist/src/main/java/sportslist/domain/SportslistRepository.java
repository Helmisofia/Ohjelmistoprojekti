package sportslist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SportslistRepository extends CrudRepository<Sport, Long> {

	// Find sports by two fields: place and exercise.
	// "Containing" means that match inside field value is enough.
	// "AllIgnoreCase" means that search is case-insensitive for all fields.
	List<Sport> findByPlaceContainingOrExerciseContainingAllIgnoreCase(String place, String exercise);   
	  
}
