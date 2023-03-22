package mk.ukim.finki.emtlab.dataloader;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    private final AuthorRepository authorRepository;
    private final BookTypeRepository bookTypeRepository;
    private final CountryRepository countryRepository;
    public DataLoader(AuthorRepository authorRepository, BookTypeRepository bookTypeRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookTypeRepository = bookTypeRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void loadData() {
        if (!bookTypeRepository.findAll().isEmpty()) {
            return;
        }

        Country country = new Country("Macedonia", "Europe");
        countryRepository.save(country);
        for (int i = 1; i < 10; i++) {
            Author author = new Author("Name author " + i, "Surname " + i, country);
            authorRepository.save(author);
        }
        for (int i = 0; i < 10; i++) {
            List<Author> authors = authorRepository.findAll();
            for (Author author : authors) {
                String name = author.getName();
                BookType newBook = new BookType("Book " + i + " " + name,
                        Category.values()[i % Category.values().length],
                        author, 10);
                bookTypeRepository.save(newBook);
            }
        }

    }

}