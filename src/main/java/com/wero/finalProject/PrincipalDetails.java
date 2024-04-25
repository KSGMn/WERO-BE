package com.wero.finalProject;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    //일반 로그인 생성자
    public PrincipalDetails(User user){
        this.user = user;
    }

    //OAuth로그ㅜ인 생성자
    public PrincipalDetails(User use, Map<String, Object> attributes ){
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes(){
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return String.valueOf(user.getRole());
            }
        });
        return collection;
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    //TODO: 수정
    @Override
    public String getUsername(){
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName(){
        return null;
    }
}
