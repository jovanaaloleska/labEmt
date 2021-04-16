package lab.emt.service;

import lab.emt.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findByName(String name);
    Optional<Country> findById (Long id);
    void deleteById (Long id);
    Optional<Country> save  (String name, String continent);

}
