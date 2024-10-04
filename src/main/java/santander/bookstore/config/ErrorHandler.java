package santander.bookstore.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import santander.bookstore.exceptions.NotFoundException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> error(Exception exception, WebRequest webRequest){
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setErro(exception.getClass().getCanonicalName());
        exceptionMessage.setPath(((ServletWebRequest)webRequest).getRequest().getServletPath());

        if(exception instanceof NotFoundException){
            exceptionMessage.setMessage(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage);
        } else {
            exceptionMessage.setMessage(exception.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionMessage);
        }

    }
}
