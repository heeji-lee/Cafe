package com.project.cafe.service;

import com.project.cafe.domain.Cafe;
import com.project.cafe.dto.CafeDTO;

public interface CafeService {
    Cafe registerMember(CafeDTO cafeDTO);
}
