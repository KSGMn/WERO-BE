package com.wero.finalProject.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @작성자:오현암
 * @작성날짜:2024/4/24
 * @파일명:User.java
 **/

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="User")
@Builder
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, updatable = false)
    private String user_id;

    @Column(name = "email", length = 320, nullable = false)
    private String email;

    @Column(name = "userName", length = 8, nullable = false)
    private String userName;

    @Column(name = "userPassword", length = 16, nullable = false)
    private String userPassword;

    @Column(name = "profile_image", length = 500, nullable = false)
    private String profile_image;

    @Column(name = "bio", length = 500, nullable = true)
    private String bio;

    @Column(name = "platform_type", length = 10, nullable = false)
    private String platform_type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserProvider provider;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.userRole.getAuthority()));
    }
    @Override
    @JsonIgnore
    public String getPassword() {
        return userPassword;
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
