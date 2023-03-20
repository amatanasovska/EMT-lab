package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.dto.BookTypeDto;
import mk.ukim.finki.emtlab.model.exceptions.BookTypeNotFoundException;

import java.util.Optional;

public interface BookTypeService {
    Optional<BookType> edit(Long Id, BookTypeDto bookTypeDto);
    void updateAvailableCopies();
}
