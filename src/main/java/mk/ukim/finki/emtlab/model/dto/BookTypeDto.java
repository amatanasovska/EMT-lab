package mk.ukim.finki.emtlab.model.dto;

import lombok.Data;
import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.enumerations.Category;

import javax.persistence.*;
@Data
public class BookTypeDto {

    String name;

    String categoryName;

    Long authorId;

    Integer availableCopies;


    public BookTypeDto(String name, String categoryName, Long authorId, Integer availableCopies) {
        this.name = name;
        this.categoryName = categoryName;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "BookTypeDto{" +
                "name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", authorId=" + authorId +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
