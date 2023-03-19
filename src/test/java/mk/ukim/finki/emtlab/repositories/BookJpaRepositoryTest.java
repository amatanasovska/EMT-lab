package mk.ukim.finki.emtlab.repositories;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookJpaRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    public void testFindAll(){
        bookRepository.save(new Book("book1", Category.DRAMA,null,10));

        Assert.assertEquals(2, bookRepository.findAll().size());
    }

}
