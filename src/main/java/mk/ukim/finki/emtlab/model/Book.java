package mk.ukim.finki.emtlab.model;

import javax.persistence.*;

import mk.ukim.finki.emtlab.model.enumerations.Category;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Category category;

    @ManyToOne
    Author author;

    Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {

        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
