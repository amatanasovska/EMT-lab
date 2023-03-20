package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookTypeDto;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.model.exceptions.BookTypeNotFoundException;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import mk.ukim.finki.emtlab.service.BookTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeRepository bookTypeRepository;
    private final AuthorRepository authorRepository;
    public BookTypeServiceImpl(BookTypeRepository bookTypeRepository, AuthorRepository authorRepository) {
        this.bookTypeRepository = bookTypeRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<BookType> edit(Long Id, BookTypeDto bookTypeDto){

                String name = bookTypeDto.getName();
                String categoryName = bookTypeDto.getCategoryName();
                Long authorId = bookTypeDto.getAuthorId();
                BookType bookType = bookTypeRepository.findById(Id).orElseThrow(() -> new BookTypeNotFoundException(Id));
                if (name != null)
                    bookType.setName(name);
                if (categoryName != null) {
                    Category category = Category.valueOf(categoryName);
                    bookType.setCategory(category);

                }
                if (authorId != null) {
                    Author author = authorRepository.findById(authorId).orElseThrow();
                    bookType.setAuthor(author);
                }
                return Optional.of(bookTypeRepository.save(bookType));

    }

    @Override
    public void updateAvailableCopies() {
        bookTypeRepository.updateAvailableCopies();
    }


}
