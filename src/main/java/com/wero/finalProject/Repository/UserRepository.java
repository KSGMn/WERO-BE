package com.wero.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wero.finalProject.domain.UserEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:UserRepository.interface
 * @기능:userRepository<->JPA
 **/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByUserId(String userId);

    UserEntity findByUserId(String userId);

    boolean existsByEmail(String email);

    boolean existsByNickName(String nickName);

    UserEntity findByNickName(String nickName);
}
