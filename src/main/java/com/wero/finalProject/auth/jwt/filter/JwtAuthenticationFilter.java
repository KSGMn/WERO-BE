package com.wero.finalProject.auth.jwt.filter;

import com.wero.finalProject.auth.jwt.provider.JwtProvider;
import com.wero.finalProject.Repository.UserRepository;
import com.wero.finalProject.domain.UserEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:JwtAuthenticationFilter
 * @기능:Jwt인증필터
 **/
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try{

            String token = parseBearerToken(request);
            if(token==null){
                filterChain.doFilter(request,response);
                return;
            }

            String userId = jwtProvider.validate(token);
            if(userId == null){
                filterChain.doFilter(request,response);
                return;
            }

            UserEntity userEntity = userRepository.findByUserId(userId);
            String role = userEntity.getRole(); //role = ROLE_USER, ROLE_ADMIN ENUM?

            //ROLE_DEVELOPER, ROLE_BOSS
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            AbstractAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userId, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        }catch (Exception e){
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);


    }
    private String parseBearerToken(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        boolean hasAuthorization = StringUtils.hasText(authorization);

        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }
}
