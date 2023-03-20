package mk.ukim.finki.emtlab.model.dto;

import lombok.Data;

@Data
public class BookDto {
    String name;
    boolean isTaken;


    public BookDto() {
    }

    public BookDto(String name, boolean isTaken) {
        this.name = name;
        this.isTaken = isTaken;
    }
}
