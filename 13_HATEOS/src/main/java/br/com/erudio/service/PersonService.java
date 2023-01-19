package br.com.erudio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;
import br.com.erudio.controller.PersonController;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    @Autowired
    private PersonRepository repository;
    public List<PersonVO> listAll(){
        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findByID(p.getKey())).withSelfRel()));
        return persons;
    }

    public PersonVO createPerson(PersonVO person){
        logger.info("Creating person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findByID(person.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO updatePerson(PersonVO person){
        var entity = repository.findById(person.getKey()).orElseThrow(ResourceNotFoundException::new);
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findByID(person.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        Person personDelete = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        repository.delete(personDelete);
    }


    public PersonVO findByID(Long id){
        logger.info("Finding one person!");
        var entity = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findByID(id)).withSelfRel());
        return vo;
    }
}
