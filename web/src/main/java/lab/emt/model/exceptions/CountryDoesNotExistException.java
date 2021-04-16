package lab.emt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CountryDoesNotExistException extends RuntimeException{
    public CountryDoesNotExistException(Long countryId) {
        super(String.format("Country with ID %id does not exist!", countryId));
    }

}
