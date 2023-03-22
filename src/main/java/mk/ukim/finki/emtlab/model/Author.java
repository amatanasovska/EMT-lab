package mk.ukim.finki.emtlab.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String name;
    String surname;

    @ManyToOne
    Country country;


    public Author() {
    }
}
