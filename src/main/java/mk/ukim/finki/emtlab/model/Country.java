package mk.ukim.finki.emtlab.model;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String name;
    String continent;

    public Country() {
    }
}
