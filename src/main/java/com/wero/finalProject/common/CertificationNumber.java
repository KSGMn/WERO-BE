package com.wero.finalProject.common;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/24
 * @파일명:CertificationNumber.class
 * @기능:랜덤_인증번호_4자리생성
 **/
public class CertificationNumber {
    public static String getCertificationNumber(){
        String certificationNumber = "";

        for(int count = 0; count<4; count++){
            certificationNumber += (int) (Math.random()*10);
        }

        return certificationNumber;
    }
}
