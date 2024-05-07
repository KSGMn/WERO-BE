package com.wero.finalProject.Repository;

import com.wero.finalProject.domain.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/07
 * @파일명:ImageRepository.interface
 * @기능:image<->JPA
 **/

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
