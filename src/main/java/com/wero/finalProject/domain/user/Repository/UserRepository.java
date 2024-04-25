package com.wero.finalProject.domain.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wero.finalProject.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);

}
