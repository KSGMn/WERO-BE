package com.wero.finalProject.Repository;

import com.wero.finalProject.domain.ImageEntity;
import com.wero.finalProject.domain.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/07
 * @파일명:ImageRepository.interface
 * @기능:image<->JPA
 **/

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    List<ImageEntity> findByUserId(UserEntity user);
}
