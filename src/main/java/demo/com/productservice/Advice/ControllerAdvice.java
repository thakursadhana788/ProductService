package demo.com.productservice.Advice;

import demo.com.productservice.DTO.ErrorDto;
import demo.com.productservice.Exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(Exception ex){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setErrorCode("400");
        errorDto.setErrorMessage("Bad Request");

        return ResponseEntity.badRequest().body(errorDto);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> ProductNotFoundException(Exception ex){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setErrorCode("404");
        errorDto.setErrorMessage("Bad Request");

        return ResponseEntity.badRequest().body(errorDto);
    }
}
