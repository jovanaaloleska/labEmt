package lab.emt.service.impl;

import lab.emt.model.Author;
import lab.emt.model.Book;
import lab.emt.model.dto.BookDto;
import lab.emt.model.enumerations.Category;
import lab.emt.model.exceptions.AuthorNotFoundException;
import lab.emt.model.exceptions.BookNotFoundException;
import lab.emt.model.exceptions.NoCopiesLeftException;
import lab.emt.repository.AuthorRepository;
import lab.emt.repository.BookRepository;
import lab.emt.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);

        Book book = new Book(name, category, author, availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(BookDto bookDTO) {
        this.bookRepository.deleteByName(bookDTO.getName());
        Author author = this.authorRepository.findById(bookDTO.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDTO.getAuthor()));

        Book book = new Book(bookDTO.getName(), bookDTO.getCategory(), author, bookDTO.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(bookId).
                orElseThrow(() -> new BookNotFoundException(bookId));

        book.setName(name);
        book.setCategory(category);

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDTO) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        Author author = this.authorRepository.findById(bookDTO.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(id));
        book.setAuthor(author);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Integer currentAvailableCopies = book.getAvailableCopies();
        if(currentAvailableCopies > 0)
        {
            book.setAvailableCopies(currentAvailableCopies - 1);
        }
        else
        {
            throw new NoCopiesLeftException(id);
        }

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }
}
