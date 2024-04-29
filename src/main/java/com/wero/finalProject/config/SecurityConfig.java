package com.wero.finalProject.config;

import com.wero.finalProject.filter.JwtAuthenticationFilter;
import com.wero.finalProject.handler.OAuth2SuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;


/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:
 * @기능1:Security_csrf(rest)비활성
 * @기능2:OAuth2_소셜로그인처리
 * @기능3:JWT_일반로그인처리
 **/

@Configurable
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private DefaultOAuth2UserService oAuth2UserService;
    private OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{ //FilterChain
        httpSecurity
                .cors(cors -> cors
                        .configurationSource(corsConfigurationSource()))
                .csrf(CsrfConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(request -> request.requestMatchers("/", "/api/v1/auth/**", "/ouath2/**", "/file/**")
                        .permitAll()
                        .requestMatchers("/api/v1/user/**").hasRole("USER")
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/board/**", "api/v1/user/*").permitAll()
                        .anyRequest()
                        .authenticated()).exceptionHandling(exceptionHandling->exceptionHandling.authenticationEntryPoint(new FailedAuthenticationEntryPoint()));

//TODO: Oauth2 소셜 로그인 yml 설정 추가후 주석 해제

//                .oauth2Login(oauth2 -> oauth2
//                        .authorizationEndpoint(endpoint -> endpoint.baseUri("/api/v1/auth/oauth2")) //원하는 형태로 api 잡아도됨
//                        .redirectionEndpoint(endpoint -> endpoint.baseUri("/oauth2/callback/*"))
//                        .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2UserService))
//                        .successHandler(oAuth2SuccessHandler)
//                )
//                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(new FailedAuthenticationEntryPoint()))
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/v1/**", corsConfiguration);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
    class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            //{"code": "NP", "message": "No Permission."}
            response.getWriter().write("{\"code\": \"NP\", \"message\": \"No Permission.\"}");

        }
    }
}
