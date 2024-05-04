package com.wero.finalProject.Repository;


import com.wero.finalProject.domain.CustomServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/02
 * @파일명:CustomServiceRepository.interface
 * @기능:CustomServiceRepository<->JPA
 **/

@Repository
public interface CustomServiceRepository extends JpaRepository<CustomServiceEntity, Long> {

}

