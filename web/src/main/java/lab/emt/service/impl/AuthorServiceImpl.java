package lab.emt.service.impl;

import lab.emt.model.Author;
import lab.emt.model.Country;
import lab.emt.model.exceptions.CountryDoesNotExistException;
import lab.emt.repository.AuthorRepository;
import lab.emt.repository.CountryRepository;
import lab.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository avtorRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findByName(String name) {
        return this.authorRepository.findByName(name);
    }

    @Override
    public Optional<Author> findById(Long authorId) {
        return this.authorRepository.findById(authorId);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryDoesNotExistException(countryId));

        Author author = new Author(name, surname, country);

        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
