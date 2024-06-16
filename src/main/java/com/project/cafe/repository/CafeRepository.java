package com.project.cafe.repository;

import com.project.cafe.domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
