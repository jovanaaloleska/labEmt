package lab.emt.service.impl;

import lab.emt.model.Country;
import lab.emt.repository.CountryRepository;
import lab.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;


    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(this.countryRepository.save(country));
    }
}
