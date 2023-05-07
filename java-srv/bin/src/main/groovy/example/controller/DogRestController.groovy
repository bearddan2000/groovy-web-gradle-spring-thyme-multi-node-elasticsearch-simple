package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.*;

import example.model.Dog;
import example.repository.DogRepository;

@RestController
public class DogRestController {

	@Autowired
	private DogRepository dogRepository;

	@PostConstruct
	private void init()
	{
	    List<Dog> list = new ArrayList<Dog>();
			list << new Dog(1L, "Am Bulldog", "White");
			list << new Dog(2L, "Foxhound", "Red");
			list << new Dog(3L, "Gr Shepard", "Black");

		dogRepository.saveAll(list);
	}

	@RequestMapping(path="/dogs", method=RequestMethod.GET)
	public Iterable<Dog> getAllDogs(){
	    return dogRepository.findAll();
	}
	
	@RequestMapping(path="/dog/{id}", method=RequestMethod.GET)
	public Optional<Dog> getDogById(@PathVariable(value="id") Integer id){
	    def d = dogRepository.findById(new Long(id));
		return Optional.of(d)
			.orElse(new Dog(0L, "test-breed", "test-color"));
	}
}
