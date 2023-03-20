package mk.ukim.finki.emtlab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)

public class NonNullableFieldException extends RuntimeException{
    public NonNullableFieldException(String field_name) {
        super("Field with name " + field_name + " cannot be null");
    }
}
