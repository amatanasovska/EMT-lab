package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
