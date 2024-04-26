package com.wero.finalProject.provider;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.*;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:EmailProvider.class
 * @기능:이메일전송
 **/

@Component
@RequiredArgsConstructor
public class EmailProvider {

    private final JavaMailSender javaMailSender;
    private final String SUBJECT ="[WE-RO] 인증 메일 입니다.";

    public boolean sendCertificationMail(String email, String certificationNumber) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            String htmlContent = getCertificationMessage(certificationNumber);

            messageHelper.setTo(email);
            messageHelper.setSubject(SUBJECT);
            messageHelper.setText(htmlContent, true);

            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private String getCertificationMessage(String certificationNumber){
        String certificationMessage = "";
        certificationMessage+="<h1></h1>";
    }

}
