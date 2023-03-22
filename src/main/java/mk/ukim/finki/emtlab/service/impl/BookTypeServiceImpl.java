package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookTypeDto;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emtlab.model.exceptions.BookTypeNotFoundException;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import mk.ukim.finki.emtlab.service.AuthorService;
import mk.ukim.finki.emtlab.service.BookTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeRepository bookTypeRepository;
    private final AuthorService authorService;
    public BookTypeServiceImpl(BookTypeRepository bookTypeRepository, AuthorService authorService) {
        this.bookTypeRepository = bookTypeRepository;
        this.authorService = authorService;
    }

    @Override
    public Optional<BookType> edit(Long Id, BookTypeDto bookTypeDto){

                String name = bookTypeDto.getName();
                String categoryName = bookTypeDto.getCategoryName();
                Long authorId = bookTypeDto.getAuthorId();
                BookType bookType = bookTypeRepository.findById(Id).orElseThrow(() -> new BookTypeNotFoundException(Id));
                Long availableCopies = Long.valueOf(bookTypeDto.getAvailableCopies());
                if (name != null)
                    bookType.setName(name);
                if (categoryName != null) {
                    Category category = Category.valueOf(categoryName);
                    bookType.setCategory(category);

                }
                if (authorId != null) {
                    Author author = authorService.findById(authorId).orElseThrow();
                    bookType.setAuthor(author);
                }
                bookType.setAvailableCopies(Math.toIntExact(availableCopies));
                return Optional.of(bookTypeRepository.save(bookType));

    }

    @Override
    public void updateAvailableCopies() {
        bookTypeRepository.updateAvailableCopies();
    }

    @Override
    public List<BookType> findAll() {
        return bookTypeRepository.findAll();
    }

    @Override
    public Optional<BookType> deleteById(Long id) {
        Optional<BookType> b = bookTypeRepository.findById(id);
        if(b.isEmpty())
            throw new BookTypeNotFoundException(id);

        bookTypeRepository.deleteById(id);

        return b;
    }

    @Override
    public Optional<BookType> save(BookTypeDto bookTypeDto) {
        String name = bookTypeDto.getName();
        Category category = Category.valueOf(bookTypeDto.getCategoryName());
        Optional<Author> author = authorService.findById(bookTypeDto.getAuthorId());
        Integer availableCopies = bookTypeDto.getAvailableCopies();

        if(author.isEmpty())
            throw new AuthorNotFoundException(bookTypeDto.getAuthorId());

        BookType bt = new BookType(name,category,author.get(),availableCopies);
        bookTypeRepository.save(bt);
        return Optional.of(bt);
    }

    @Override
    public Optional<BookTypeDto> findById(Long id) {

        BookType bookType= bookTypeRepository.findById(id).get();

        BookTypeDto btd = new BookTypeDto(bookType.getId(),
                                            bookType.getName(),
                bookType.getCategory().name(),
                bookType.getAuthor().getId(),
                bookType.getAvailableCopies());

        return Optional.of(btd);
    }

    @Override
    public Optional<BookType> find(Long id) {
        return bookTypeRepository.findById(id);
    }


}
