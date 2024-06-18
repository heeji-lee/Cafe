package com.project.cafe.service;

import com.project.cafe.dto.CafeDTO;
import com.project.cafe.domain.Cafe;
import com.project.cafe.repository.CafeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository, ModelMapper modelMapper) {
        this.cafeRepository = cafeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Cafe registerMember(CafeDTO cafeDTO) {
        Cafe cafe = modelMapper.map(cafeDTO, Cafe.class);
        return cafeRepository.save(cafe);
    }
}
