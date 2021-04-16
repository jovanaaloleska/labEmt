package lab.emt.service;

import lab.emt.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();
    Optional<Author> findByName(String name);
    Optional<Author> findById (Long authorId);
    Optional<Author> save  (String name, String surname, Long countryId);
    void deleteById (Long id);
}
