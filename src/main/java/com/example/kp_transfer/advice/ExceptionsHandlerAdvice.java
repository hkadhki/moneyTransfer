package com.example.kp_transfer.advice;

import com.example.kp_transfer.exceptions.ErrorTransferException;
import com.example.kp_transfer.exceptions.InvalidDataException;
import com.example.kp_transfer.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> invalidDataExceptionHandler(InvalidDataException e){
        logger.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorTransferException.class)
    public ResponseEntity<String> errorTransferExceptionHandler(ErrorTransferException e){
        logger.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
