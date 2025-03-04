package demo.com.productservice.Advice;

import demo.com.productservice.DTO.ErrorDto;
import demo.com.productservice.Exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException ex){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setErrorCode("400");
        errorDto.setErrorMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(errorDto);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> ProductNotFoundException(ProductNotFoundException ex){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setErrorCode("404");
        errorDto.setErrorMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(errorDto);
    }
}
