package com.wero.finalProject.common;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:ResponseMessage.interface
 * @기능:에러,성공메세지_생성
 **/
public interface ResponseMessage {
    String SUCCESS = "success";
    String VALIDATION_FAIL = "validation failed";
    String DUPLICATE_ID = "duplicate id";
    String SIGN_IN_FAIL = "sing in fail";
    String CERTIFICATION_FAIL = "certification fail";
    String DATABASE_ERROR = "database_error";
    String MAIL_FAIL = "Mail Send Failed";
}
