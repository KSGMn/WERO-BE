package com.wero.finalProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
