package com.project.cafe.service;

import com.project.cafe.domain.Notice;
import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticePageRequestDTO;
import com.project.cafe.dto.NoticePageResponseDTO;
import com.project.cafe.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
// all or nothing,
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public Long register(NoticeDTO noticeDTO) {
//        Notice notice = modelMapper.map(noticeDTO, Notice.class);
//        Long bno = noticeRepository.save(notice).getNo_cd();
//        return bno;
//    }

    @Override
    public NoticeDTO read(Long cd) {
        Optional<Notice> result = noticeRepository.findById(cd);
        Notice notice = result.orElseThrow();
        NoticeDTO noticeDTO = modelMapper.map(notice, NoticeDTO.class);

        return noticeDTO;
    }

//    @Override
//    public void update(NoticeDTO noticeDTO) {
//        Optional<Notice> result = noticeRepository.findById(noticeDTO.getNo_cd());
//        Notice notice = result.orElseThrow();
//        notice.changeTitleAndContent(noticeDTO.getNo_title(),noticeDTO.getNo_content());
//        // 적용하기.
//        noticeRepository.save(notice);
//    }

//    @Override
//    public void delete(Long no_cd) {
//        // 레스트 방식일 때는 , 유효성 체크해서 없다는 메세지 전달해줘야 함.
//    Optional<Notice> result = noticeRepository.findById(bno);
//    Notice notice = result.orElseThrow();
//        noticeRepository.deleteById(no_cd);
//    }

    @Override
    public NoticePageResponseDTO<NoticeDTO> list(NoticePageRequestDTO noticepageRequestDTO) {
        Pageable pageable = noticepageRequestDTO.getPageable("cd"); // 기준 필드를 변경해야 할 수 있음

        Page<Notice> result = noticeRepository.findAll(pageable);
        List<NoticeDTO> dtoList = result.getContent().stream()
                .map(notice -> modelMapper.map(notice, NoticeDTO.class))
                .collect(Collectors.toList());

        return NoticePageResponseDTO.<NoticeDTO>withAll()
                .noticepageRequestDTO(noticepageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }
}
