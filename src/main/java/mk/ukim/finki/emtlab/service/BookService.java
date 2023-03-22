package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.exceptions.BookAlreadyTakenException;
import mk.ukim.finki.emtlab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.emtlab.model.exceptions.NonNullableFieldException;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> takeBook(Long book_type_id, Long id);

    }
