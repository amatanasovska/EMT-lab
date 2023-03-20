package mk.ukim.finki.emtlab.model;

import javax.persistence.*;

import lombok.Data;
import mk.ukim.finki.emtlab.model.enumerations.Category;

@Entity
@Data
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String name;

    Category category;

    @ManyToOne
    Author author;

    Integer availableCopies;

    public BookType(String name, Category category, Author author, Integer availableCopies) {

        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookType() {

    }
}
