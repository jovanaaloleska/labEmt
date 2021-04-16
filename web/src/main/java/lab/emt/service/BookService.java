package lab.emt.service;

import lab.emt.model.Book;
import lab.emt.model.dto.BookDto;
import lab.emt.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {


    Optional<Book> findByName(String name);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void deleteById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDTO);

    Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit (Long id, BookDto bookDTO);

    Optional<Book> markAsTaken (Long id);

    Page<Book> findAllWithPagination(Pageable pageable);
}
