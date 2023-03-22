package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long Id);

}
