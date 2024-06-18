package com.project.cafe.repository;

import com.project.cafe.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 스프링 JPA 진영에서, 기본적인 쿼리 메소드를 만들어줌. crud
public interface NoticeRepository extends JpaRepository<Notice, Long> { // 여기 원래 BoardSearch도 있었음
    List<Notice> findByCd (Long cd);


}