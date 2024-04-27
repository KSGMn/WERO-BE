package com.wero.finalProject.common;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:ResponseCode.interface
 * @기능:에러,성공코드_기능
 **/
public interface ResponseCode {

    String SUCCESS = "SU";
    String VALIDATION_FAIL = "VF";
    String DUPLICATE_ID = "DI";
    String SIGN_IN_FAIL = "SF";
    String CERTIFICATION_FAIL = "CF";
    String DATABASE_ERROR = "DBE";
    String MAIL_FAIL = "MF";
}
