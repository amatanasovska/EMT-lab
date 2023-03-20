package mk.ukim.finki.emtlab.repositories;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTypeJpaRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookTypeRepository bookTypeRepository;
    @Test
    public void testFindAll(){

        BookType bookType = bookTypeRepository.save(new BookType("book1", Category.DRAMA, null, 1));

        bookRepository.save(new Book(bookType));


        Assert.assertEquals(1, bookRepository.findAll().size());
    }

}
