package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String name) {
        super("Category with name " + name + " not found.");
    }
}
