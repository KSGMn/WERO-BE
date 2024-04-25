package com.wero.finalProject.User.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @작성자:오현암,김선규
 * @작성날짜:2024/4/24
 * @파일명:User.class
 **/

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "User")
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "email", length = 320, nullable = false)
    private String email;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "userName", length = 8, nullable = false)
    private String userName;

    @Column(name = "profile_image", length = 500, nullable = false)
    private String profile_image;

    @Column(name = "bio", length = 500, nullable = true)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = "UserRolse", nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "userProvider", nullable = false)
    private UserProvider UserProvider;


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.userRole.getAuthority()));
    }

    @Override
    @JsonIgnore
    public String getPassword(){
        return password;
    }
    @Override
    @JsonIgnore
    public String getUsername() {
        return user_id;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
