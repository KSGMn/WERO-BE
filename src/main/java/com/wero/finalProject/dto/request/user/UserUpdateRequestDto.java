package com.wero.finalProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/03
 * @파일명:UserUpdateRequestDto
 **/
@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z][0-9]{8,15}$")
    private String password;

    @NotBlank
    private String nickName;

    @NotBlank
    private String gender;


}
