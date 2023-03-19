package mk.ukim.finki.emtlab.model;

import javax.persistence.*;

@Entity
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
