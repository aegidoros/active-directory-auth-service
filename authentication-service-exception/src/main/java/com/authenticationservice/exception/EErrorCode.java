package com.authenticationservice.exception;

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
public enum EErrorCode {

  UNKNOWN_ERROR("unknown-error-000");

  private String errorCode;

  /**
   *
   * @param errorCode
   */
  EErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   *
   * @return
   */
  public String getErrorCode() {
    return this.errorCode;
  }

}


