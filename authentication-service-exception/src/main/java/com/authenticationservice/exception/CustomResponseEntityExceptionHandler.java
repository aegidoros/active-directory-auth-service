package com.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 * @since JDK1.8
 */

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   *
   * @param ex
   * @return
   */
  @ExceptionHandler({ServiceException.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ResponseEntity<Object> serviceException(ServiceException ex) {
    ErrorDTO errorDTO = new ErrorDTO();
    errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    errorDTO.setErrorCode(ex.getErrorCode());
    errorDTO.setDeveloperMessage(ex.getMessage());
    errorDTO.setUserMessage(ex.getMessage());
    errorDTO.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

    if (ex.getStatus() != null) {
      errorDTO.setStatus(ex.getStatus().value());
      return new ResponseEntity<>(errorDTO, ex.getStatus());
    } else {
      errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
