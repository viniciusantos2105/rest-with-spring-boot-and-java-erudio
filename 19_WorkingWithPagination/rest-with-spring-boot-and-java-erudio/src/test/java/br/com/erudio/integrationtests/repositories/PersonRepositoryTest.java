package br.com.erudio.integrationtests.repositories;

import br.com.erudio.configs.TestConfigs;
import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.erudio.integrationtests.vo.PersonVO;
import br.com.erudio.integrationtests.wrappers.WrapperPersonVO;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    public PersonRepository repository;

    private static Person person;

    @BeforeAll
    public static void setup(){
        person = new Person();
    }

    @Test
    @Order(1)
    public void testFindByName() throws JsonMappingException, JsonProcessingException {

        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "firstName"));
        person = repository.findPersonsByNames("vin", pageable).getContent().get(0);

        assertNotNull(person.getId());
        assertNotNull(person.getFirstName());
        assertNotNull(person.getLastName());
        assertNotNull(person.getAddress());
        assertNotNull(person.getGender());

        assertEquals(563, person.getId());

        assertEquals("Devinne", person.getFirstName());
        assertEquals("Pim", person.getLastName());
        assertEquals("4 Talmadge Road", person.getAddress());
        assertEquals("Female", person.getGender());

    }

    @Test
    @Order(1)
    public void testDisablePerson() throws JsonMappingException, JsonProcessingException {

        repository.disabledPerson(person.getId());
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "firstName"));
        person = repository.findPersonsByNames("vin", pageable).getContent().get(0);

        assertNotNull(person.getId());
        assertNotNull(person.getFirstName());
        assertNotNull(person.getLastName());
        assertNotNull(person.getAddress());
        assertNotNull(person.getGender());
        assertFalse(person.getEnabled());

        assertEquals(563, person.getId());

        assertEquals("Devinne", person.getFirstName());
        assertEquals("Pim", person.getLastName());
        assertEquals("4 Talmadge Road", person.getAddress());
        assertEquals("Female", person.getGender());

    }
}
