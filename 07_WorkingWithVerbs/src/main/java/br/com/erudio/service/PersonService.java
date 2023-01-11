package br.com.erudio.service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> listAll(){
        return repository.findAll();
    }

    public Person createPerson(Person person){
        logger.info("Creating person");
        return repository.save(person);
    }

    public Person updatePerson(Person person){
        Person personUpdate = repository.findById(person.getId()).orElseThrow(ResourceNotFoundException::new);
        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setLastName(person.getLastName());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setGender(person.getGender());
        return repository.save(personUpdate);
    }

    public void delete(Long id){
        Person personDelete = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        repository.delete(personDelete);
    }


    public Person findByID(Long id){
        logger.info("Finding one person!");

        return repository.findById(id).orElseThrow(ResolutionException::new);
    }
}
