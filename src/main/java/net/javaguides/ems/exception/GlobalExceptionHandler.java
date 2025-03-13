package net.javaguides.ems.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Handle specific excception-EmployeeException

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorDetails> handleEmployeeException(EmployeeException employeeException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                employeeException.getMessage(),
                webRequest.getDescription(false),
                "EMPLOYEE_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //Handle Generic Exception
    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ErrorDetails> handleGenericException(Exception exception,WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
