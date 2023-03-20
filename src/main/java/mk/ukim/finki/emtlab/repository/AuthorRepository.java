package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findById(Long Id);


}
