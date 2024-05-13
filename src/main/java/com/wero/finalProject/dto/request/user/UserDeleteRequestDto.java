package com.wero.finalProject.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/13
 * @파일명:UserDeleteRequestDto.class
 * @기능:JSON파라미터값
 **/

@Getter
@Setter
@NoArgsConstructor
public class UserDeleteRequestDto {

    @NotBlank
    private String userId;
}
