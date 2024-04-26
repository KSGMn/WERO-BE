package com.wero.finalProject.auth.jwt.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:JwtProivder.class
 * @기능:Jwt토큰_발급
 **/

@Component
public class JwtProvider {
    @Value("${secret-key}")
    private String secretKey;
    public String create(String userId){

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS)); // 현재시간 기준 먼저
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(userId).setIssuedAt(new Date()).setExpiration(expiredDate)
                .compact();
        return jwt;
    }


    //TODO: jwt 검증
    public String validate(String jwt) {

        String subject = null;
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        try {
            subject = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJwt(jwt)
                    .getBody()
                    .getSubject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return subject;
    }
}
