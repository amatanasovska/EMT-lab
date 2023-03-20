package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long Id)
    {
        super("Author with Id " + Id + " not found.");
    }
}
