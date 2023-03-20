package mk.ukim.finki.emtlab.model.idclass;

import mk.ukim.finki.emtlab.model.BookType;

import javax.persistence.*;
import java.io.Serializable;

public class BookId implements Serializable {

    Long bookId;

    Long bookType;
}
