package com.wero.finalProject.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wero.finalProject.Repository.UserRepository;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.user.UserUpdateRequestDto;
import com.wero.finalProject.dto.response.ResponseDto;
import com.wero.finalProject.dto.response.user.UserUpdateResponseDto;
import com.wero.finalProject.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/03
 * @파일명:UserServiceImpl.class
 * @기능:유저_수정_서비스_로직_상세구현
 **/

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super UserUpdateResponseDto> userUpdate(UserUpdateRequestDto dto, String userId) {
        try {
            UserEntity user = userRepository.findByUserId(userId);
            if (user == null)
                return UserUpdateResponseDto.notExistUser();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            user.patchUserEntity(dto, userId);

            userRepository.save(user);
            return UserUpdateResponseDto.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.dataBaseError();
        }

    }

    @Override
    public UserEntity findUserById(String userId) {
        UserEntity user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

}
