package com.authenticationservice.exception;

        import lombok.Data;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Data
public class ErrorDTO {

  private String date;
  private int status;
  private String errorCode;
  private String developerMessage;
  private String userMessage;
  private String moreInfo;


}
