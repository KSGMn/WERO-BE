package com.wero.finalProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/07
 * @파일명:UserUpdateEmailRequestDto
 **/

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateEmailRequestDto {
    @NotBlank
    private String email;

}
