package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
