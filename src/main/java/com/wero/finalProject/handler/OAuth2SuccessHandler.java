package com.wero.finalProject.handler;

import com.wero.finalProject.provider.JwtProvider;
import com.wero.finalProject.domain.CustomOauth2User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:OAuth2SuccessHandler.class
 * @기능:OAuth2_인증_성공_처리
 **/
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CustomOauth2User oauth2User =(CustomOauth2User)authentication.getPrincipal();

        String userId = oauth2User.getName();
        String token = jwtProvider.create(userId);

        response.sendRedirect("http://localhost:3000/auth/oauth2-response/" + token +"/3600");

    }

}
