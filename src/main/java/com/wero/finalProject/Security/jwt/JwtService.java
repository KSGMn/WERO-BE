package com.wero.finalProject.Security.jwt;

import java.security.KeyPair;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;

/**
 * @작성자:김선규
 * @작성날짜:2024/4/25
 * @파일명:JwtService.java
 **/

@Service
@AllArgsConstructor
public class JwtService {

    @Autowired
    private final KeyPair keyPair;

    public Token generateAccessToken(String Email) {
        long expirationTime = TimeUnit.MINUTES.toMillis(15); // 15분
        String accessToken = Jwts.builder()
                .setSubject(Email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256) // 개인키로 서명
                .compact();

        return Token.builder()
                .grantType("Bearer")
                .access_token(accessToken)
                .build();
    }

    public Token generateRefreshToken(String Email) {
        long expirationTime = TimeUnit.HOURS.toMillis(15); // 8시간
        String refreshToken = Jwts.builder()
                .setSubject(Email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256) // 개인키로 서명
                .compact();

        return Token.builder()
                .grantType("Bearer")
                .refresh_token(refreshToken)
                .build();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(keyPair.getPublic()) // 공개키로 검증
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateRefreshToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(keyPair.getPublic()) // 공개키로 검증
                    .build()
                    .parseClaimsJws(token);

            // 만료 날짜 검사
            return !claims.getBody().getExpiration().before(new Date());
        } catch (SignatureException ex) {
            // 서명 검증 실패
            return false;
        } catch (Exception e) {
            // 다른 모든 예외 처리
            return false;
        }
    }

}
