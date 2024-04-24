package com.wero.finalProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:SecurityConfig.class
 **/

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
}
