package br.com.erudio.unittests.mapper.mocks;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookVO mockVO() {
        return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setTitle("Title test"+ number);
        book.setAuthor("Author test"+ number);
        book.setLaunchDate(new Date());
        book.setPrice(39.90);
        book.setId(number.longValue());
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setTitle("Title test"+ number);
        book.setAuthor("Author test"+ number);
        book.setLaunchDate(new Date());
        book.setPrice(39.90);
        book.setKey(number.longValue());
        return book;
    }

}
