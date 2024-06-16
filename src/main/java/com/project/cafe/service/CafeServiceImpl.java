package com.project.cafe.service;

import com.project.cafe.domain.Cafe;
import com.project.cafe.dto.CafeDTO;
import com.project.cafe.repository.CafeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public Cafe registerMember(CafeDTO cafeDTO) {
        Cafe member = new Cafe();
        member.setUserId(cafeDTO.getUserId());
        member.setPassword(cafeDTO.getPassword());
        member.setGender(cafeDTO.getGender());
        member.setPhone(cafeDTO.getPhone());
        member.setBirthday(cafeDTO.getBirthday());
        return cafeRepository.save(member);
    }
}
