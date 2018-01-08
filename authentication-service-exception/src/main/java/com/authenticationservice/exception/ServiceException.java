package com.authenticationservice.exception;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 * @version 1.0
 * @see
 * @since JDK1.8
 */
@Data
@Log4j2
public class ServiceException extends BaseException {

  /**
   *
   */
  protected static final String FILE_NAME_ERRORS = "service_error";

  /**
   *
   */
  protected final String errorCode;

  /**
   *
   */
  protected final HttpStatus status;

  /**
   * @param errorCode - The errorCode error
   */
  public ServiceException(String errorCode) {
    super(getMessage(errorCode));
    this.errorCode = errorCode;
    this.status = null;
  }

  /**
   * @param errorCode - The errorCode error
   * @param status - HttpStatus code
   */
  public ServiceException(String errorCode, HttpStatus status) {
    super(getMessage(errorCode));
    this.errorCode = errorCode;
    this.status = status;
  }

  /**
   * @param errorCode - The error exceptionMessage
   * @param tex       - Throwable exception
   */
  public ServiceException(String errorCode, Throwable tex) {
    super(getMessage(errorCode), tex);
    this.errorCode = errorCode;
    this.status = null;
  }

  /**
   * @param errorCode - The errorCode error
   * @param locale    - Locale language
   */
  public ServiceException(String errorCode, Locale locale) {
    super(getMessage(errorCode, locale));
    this.errorCode = errorCode;
    this.status = null;
  }

  /**
   * @param errorCode - The errorCode error
   * @param ex        - The exception
   * @param locale    - Locale language
   */
  public ServiceException(String errorCode, Throwable ex, Locale locale) {
    super(getMessage(errorCode, locale), ex);
    this.errorCode = errorCode;
    this.status = null;
  }

  /**
   * @param errorCode - The errorCode error
   * @param ex        - The exception
   * @param locale    - Locale language
   * @param status    - HttpStatus code
   */
  public ServiceException(String errorCode, Throwable ex, Locale locale, HttpStatus status) {
    super(getMessage(errorCode, locale), ex);
    this.errorCode = errorCode;
    this.status = status;
  }

  /**
   * @param errorCode - The error errorCode
   * @return String - The error exceptionMessage
   */
  protected static String getMessage(String errorCode) {
    return getMessage(errorCode, Locale.ENGLISH);
  }

  /**
   * @param errorCode - The error errorCode
   * @param locale    - Locale language
   * @return String - The error exceptionMessage
   */
  protected static String getMessage(String errorCode, Locale locale) {
    String message = null;
    try {
      message = PropertyResourceBundle.getBundle(FILE_NAME_ERRORS, locale).getString(errorCode);
    } catch (MissingResourceException mre) {
      log.error("Message for errorCode error {}, not found, {} ", errorCode, mre);
    }
    return message;
  }
}
