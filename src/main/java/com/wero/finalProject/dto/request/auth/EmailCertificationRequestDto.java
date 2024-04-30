package com.wero.finalProject.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:EmailCertificationRequestDto
 * @기능:이메일_인증_번호_전송
 **/
@Getter
@Setter
@NoArgsConstructor
public class EmailCertificationRequestDto{

    @NotBlank
    private String id;

    @NotBlank
    @Email
    private String email;

}
