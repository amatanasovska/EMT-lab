package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
    Optional<BookType> findByName(String name);

}
