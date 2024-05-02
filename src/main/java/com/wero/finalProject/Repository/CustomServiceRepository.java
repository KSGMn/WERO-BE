package com.wero.finalProject.Repository;


import com.wero.finalProject.domain.CustomServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/

@Repository
public interface CustomServiceRepository extends JpaRepository<CustomServiceEntity, Long> {

}

