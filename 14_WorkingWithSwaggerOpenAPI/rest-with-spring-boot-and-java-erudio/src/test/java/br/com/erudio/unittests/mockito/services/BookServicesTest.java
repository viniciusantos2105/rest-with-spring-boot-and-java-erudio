package br.com.erudio.unittests.mockito.services;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.BookServices;
import br.com.erudio.services.PersonServices;
import br.com.erudio.unittests.mapper.mocks.MockBook;
import br.com.erudio.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServicesTest {

	MockBook input;

	@InjectMocks
	private BookServices service;

	@Mock
	BookRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(entity));

		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Title test1", result.getTitle());
		assertEquals("Author test1", result.getAuthor());
		assertEquals(39.90, result.getPrice());
		assertNotNull(result.getLaunchDate());
	}
	@Test
	void testCreate() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);

		Book persisted = entity;
		persisted.setId(1L);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Title test1", result.getTitle());
		assertEquals("Author test1", result.getAuthor());
		assertEquals(39.90, result.getPrice());
		assertNotNull(result.getLaunchDate());
	}
	
	@Test
	void testCreateWithNullPerson() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "Não é permitido Objeto nulo!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}


	@Test
	void testUpdate() {
		Book entity = input.mockEntity(1);
		
		Book persisted = entity;
		persisted.setId(1L);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1L);
		

		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());

		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Title test1", result.getTitle());
		assertEquals("Author test1", result.getAuthor());
		assertEquals(39.90, result.getPrice());
		assertNotNull(result.getLaunchDate());
	}
	

	
	@Test
	void testUpdateWithNullPerson() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "Não é permitido Objeto nulo!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testDelete() {
		Book entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}
	
	@Test
	void testFindAll() {
		List<Book> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var books = service.findAll();
		
		assertNotNull(books);
		assertEquals(14, books.size());
		
		var bookOne = books.get(1);
		
		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());

		assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Title test1", bookOne.getTitle());
		assertEquals("Author test1", bookOne.getAuthor());
		assertEquals(39.90, bookOne.getPrice());
		assertNotNull(bookOne.getLaunchDate());
		
		var BookFour = books.get(4);
		
		assertNotNull(BookFour);
		assertNotNull(BookFour.getKey());
		assertNotNull(BookFour.getLinks());

		assertTrue(BookFour.toString().contains("links: [</api/book/v1/4>;rel=\"self\"]"));
		assertEquals("Title test4", BookFour.getTitle());
		assertEquals("Author test4", BookFour.getAuthor());
		assertEquals(39.90, BookFour.getPrice());
		assertNotNull(BookFour.getLaunchDate());
		
		var BookSeven = books.get(7);
		
		assertNotNull(BookSeven);
		assertNotNull(BookSeven.getKey());
		assertNotNull(BookSeven.getLinks());

		assertTrue(BookSeven.toString().contains("links: [</api/book/v1/7>;rel=\"self\"]"));
		assertEquals("Title test7", BookSeven.getTitle());
		assertEquals("Author test7", BookSeven.getAuthor());
		assertEquals(39.90, BookSeven.getPrice());
		assertNotNull(BookSeven.getLaunchDate());


	}

}
