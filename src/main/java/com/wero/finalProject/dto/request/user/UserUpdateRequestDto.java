package com.wero.finalProject.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/03
 * @파일명:UserUpdateRequestDto
 **/
@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z][0-9]{8,15}$")
    private String password;

    @NotNull
    private List<String> profImage;

    @NotBlank
    private String nickName;

    @NotBlank
    private String gender;


}
