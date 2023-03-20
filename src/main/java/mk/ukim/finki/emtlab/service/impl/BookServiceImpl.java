package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.exceptions.BookAlreadyTakenException;
import mk.ukim.finki.emtlab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.emtlab.model.exceptions.NonNullableFieldException;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import mk.ukim.finki.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookTypeRepository bookTypeRepository;

    public BookServiceImpl(BookRepository bookRepository, BookTypeRepository bookTypeRepository) {
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto){


            String name = bookDto.getName();
            boolean isTaken = bookDto.isTaken();
            if(name==null) throw new NonNullableFieldException("name");

            BookType bookType = bookTypeRepository.findByName(name).orElseThrow(()->new CategoryNotFoundException(name));
            Book book = new Book(bookType,isTaken);

            return Optional.of(bookRepository.save(book));



    }

    @Override
    public Optional<Book> takeBook(Long book_type_id, Long id) {

            Book book = bookRepository.findByBookIdAndBookType_Id(id,book_type_id)
                    .orElseThrow(()->new BookNotFoundException(book_type_id,id));
            if (book.isTaken())
                throw new BookAlreadyTakenException(book_type_id, id);
            book.setTaken(true);
            bookRepository.save(book);
            return Optional.of(book);



    }


}
