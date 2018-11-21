package webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No products found under this category")
public class NoProductFoundUnderCategoryException extends RuntimeException {
	private static final long serialVersionUID = 477474790387536046L;

}
