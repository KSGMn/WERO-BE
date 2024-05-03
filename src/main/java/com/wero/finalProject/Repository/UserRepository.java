package com.wero.finalProject.Repository;

import com.wero.finalProject.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
