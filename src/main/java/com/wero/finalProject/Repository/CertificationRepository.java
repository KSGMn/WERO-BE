package com.wero.finalProject.Repository;

import com.wero.finalProject.auth.certification.Certification;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:CertificationRepository.interface
 * @기능:CertificationRepository<->JPA
 **/
@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByUserId(String userId);

    @Transactional
    void deleteByUserId(String userId);
}

