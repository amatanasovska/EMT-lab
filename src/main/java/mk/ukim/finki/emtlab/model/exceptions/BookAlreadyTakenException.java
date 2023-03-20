package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)

public class BookAlreadyTakenException extends RuntimeException {
    public BookAlreadyTakenException(Long book_type_id, Long id) {
        super("Book with book type id " + book_type_id + " and id " + id + " is already taken.");
    }
}
