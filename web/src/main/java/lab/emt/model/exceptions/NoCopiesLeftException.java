package lab.emt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoCopiesLeftException extends RuntimeException{
    public NoCopiesLeftException(Long id) {
        super(String.format("Book with ID %d has no copies left",id));
    }
}
