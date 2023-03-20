package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class BookTypeNotFoundException extends RuntimeException{

    public BookTypeNotFoundException(Long Id) {
        super("No book type with Id " + Id + " was found.");
    }
}
