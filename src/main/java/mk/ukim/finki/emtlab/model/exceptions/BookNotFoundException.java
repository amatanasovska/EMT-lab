package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long book_type_id, Long book_id) {
        super("The book from type " + book_type_id + " with id " + book_id + " cannot be found.");
    }
}
