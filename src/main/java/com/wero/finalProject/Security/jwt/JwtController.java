package com.wero.finalProject.Security.jwt;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.User.Repository.UserRepository;
import com.wero.finalProject.User.domain.User;
import com.wero.finalProject.User.dto.UserDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @작성자:김선규
 * @작성날짜:2024/4/25
 * @파일명:JwtController.java
 **/

@RestController
public class JwtController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    private final JwtService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtController(JwtService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;

    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {// @RequestBody는 하나만 쓰자

        User findUser = userRepository.findByEmail(userDto.getEmail());

        if (findUser != null) {
            logger.info("중복된 이메일: " + userDto.getEmail());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: " + userDto.getUserName() + "은 중복된 이름입니다");
        }
        User newUser = User.builder()
                .email(userDto.getEmail())
                .passWord(passwordEncoder.encode(userDto.getPassWord()))
                .userName(userDto.getUserName())
                .access_token(Optional.ofNullable(userDto.getAccess_token()).orElse(""))
                .profile_image(Optional.ofNullable(userDto.getProfile_image()).orElse(""))
                .platform_type(userDto.getPlatform_type())
                .roles(userDto.getRoles())
                .build();

        User saveUser = userRepository.save(newUser);
        return ResponseEntity.ok(saveUser);

    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody JwtTokenRequest jwtTokenRequest,
            HttpServletResponse response) {
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtTokenRequest.email(), jwtTokenRequest.passWord()));

            String Email = jwtTokenRequest.email();
            Token accessToken = tokenService.generateAccessToken(Email);
            Token refreshToken = tokenService.generateRefreshToken(Email);

            Token responseToken = Token.builder()
                    .grantType("Bearer")
                    .access_token(accessToken.getAccess_token())
                    .refresh_token(refreshToken.getRefresh_token())
                    .build();

            // 쿠키 생성 및 설정
            Cookie accessTokenCookie = new Cookie("accessToken", accessToken.getAccess_token());
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(60 * 30); // 30분

            Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken.getRefresh_token());
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setMaxAge(60 * 60 * 24 * 7); // 7일

            // 응답에 쿠키 추가
            response.addCookie(accessTokenCookie);
            response.addCookie(refreshTokenCookie);

            return ResponseEntity.ok(responseToken);
        } catch (Exception e) {
            logger.error("Login failed: ", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/token/refresh")
    public ResponseEntity<Token> refreshToken(@RequestBody Token refreshTokenRequest) {
        String refreshToken = refreshTokenRequest.getRefresh_token();
        // 리프레시 토큰의 유효성 검사 및 사용자 이름 추출
        if (tokenService.validateRefreshToken(refreshToken)) {
            String username = tokenService.getUsernameFromToken(refreshToken);
            Token newAccessToken = tokenService.generateAccessToken(username);

            // 새 액세스 토큰으로 Token 객체 생성 (리프레시 토큰은 재발급하지 않음)
            Token responseToken = Token.builder()
                    .grantType("Bearer")
                    .access_token(newAccessToken.getAccess_token())
                    .build();

            return ResponseEntity.ok(responseToken);
        } else {
            return ResponseEntity.status(401).body(null); // 유효하지 않은 리프레시 토큰 처리
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        // 액세스 토큰 쿠키 만료
        Cookie accessTokenCookie = new Cookie("accessToken", null);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(0); // 쿠키를 즉시 만료시킴
        response.addCookie(accessTokenCookie);

        // 리프레시 토큰 쿠키도 만료
        Cookie refreshTokenCookie = new Cookie("refreshToken", null);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(0); // 쿠키를 즉시 만료시킴
        response.addCookie(refreshTokenCookie);

        // 로그아웃 성공 응답
        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/welcome")
    public String Welcome() {
        return "Your Welcome";
    }

}
