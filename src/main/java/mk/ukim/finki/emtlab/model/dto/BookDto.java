package mk.ukim.finki.emtlab.model.dto;

import lombok.Data;

@Data
public class BookDto {
//    String name;
    Boolean isTaken;
    Long bookType;

    public BookDto() {
    }

    public BookDto(boolean isTaken, Long bookType) {
        this.isTaken = isTaken;
        this.bookType = bookType;
    }

    public Boolean isTaken() {
        return isTaken;
    }
}
