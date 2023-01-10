package br.com.erudio.controller;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping("/{id}")
    @GetMapping
    public Person findByID(@PathVariable(value = "id") Long id) {
        return service.findByID(id);
    }

    @RequestMapping("/")
    @GetMapping
    public List<Person> listAll() {
        return service.listAll();
    }

    @RequestMapping("/create")
    @PostMapping
    public Person create(@RequestBody Person person){
        return service.createPerson(person);
    }

    @RequestMapping("/update")
    @PutMapping
    public Person update(@RequestBody Person person){
        return service.updatePerson(person);
    }
}