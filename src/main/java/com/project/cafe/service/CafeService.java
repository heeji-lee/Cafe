package com.project.cafe.service;

import com.project.cafe.dto.CafeDTO;
import com.project.cafe.domain.Cafe;

public interface CafeService {
    Cafe registerMember(CafeDTO cafeDTO);
}
