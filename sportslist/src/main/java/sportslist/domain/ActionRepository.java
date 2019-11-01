package sportslist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action, Long> {

	    List<Action> findByName(String name);
    
}