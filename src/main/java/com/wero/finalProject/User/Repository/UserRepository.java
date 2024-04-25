package com.wero.finalProject.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wero.finalProject.User.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
