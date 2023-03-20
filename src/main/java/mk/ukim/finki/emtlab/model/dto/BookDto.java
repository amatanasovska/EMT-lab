package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.enumerations.Category;

import javax.persistence.ManyToOne;

public class BookDto {
    boolean isTaken;

    public BookDto() {
    }

    public BookDto(boolean isTaken) {
        this.isTaken = isTaken;
    }
}
