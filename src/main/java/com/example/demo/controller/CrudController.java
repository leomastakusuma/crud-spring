package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CrudController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/person")
	public List<Person> getAllPerson() {		
		return personRepository.findAll();
	}

	@PostMapping("/person")
	public Person createPerson( @RequestBody Person person) {
		return person;
	}

	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable(value = "id") Long personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));
	}

	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails) {

		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", personId));

		person.SetfirstName(personDetails.getfirstName());
		person.SetlastName(personDetails.getlastName());

		Person updatedPerson = personRepository.save(person);
		return updatedPerson;
	}

}
