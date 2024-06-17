package com.project.cafe.repository;

import com.project.cafe.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 스프링 JPA 진영에서, 기본적인 쿼리 메소드를 만들어줌. crud
public interface NoticeRepository extends JpaRepository<Notice, Long> { // 여기 원래 BoardSearch도 있었음

    //    Page<Notice> findByTitleContainingOrderByBnoDesc(String no_title, String keyword, Pageable pageable);

    @Query("select  b from Notice b where b.no_title  like concat('%',:keyword ,'%')")
    Page<Notice> findByKeyword(String keyword, Pageable pageable);

    @Query(value = "select now()", nativeQuery = true)
    String getTime();

}