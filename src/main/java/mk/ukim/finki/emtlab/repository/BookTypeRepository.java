package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
    Optional<BookType> findByName(String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update BOOK_TYPE set \n" +
            "AVAILABLE_COPIES = \n" +
            "(select count(*) from BOOK " +
            "where BOOK_TYPE.ID=BOOK.BOOK_TYPE_ID and " +
            "IS_TAKEN = 0);", nativeQuery = true)

    void updateAvailableCopies();

    void deleteById(Long Id);

}
