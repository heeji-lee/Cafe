package com.project.cafe.service;

import com.project.cafe.domain.Notice;
import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticeListReplyCountDTO;
import com.project.cafe.dto.Notice_PageRequestDTO;
import com.project.cafe.dto.Notice_PageResponseDTO;
import com.project.cafe.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
// all or nothing,
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(NoticeDTO noticeDTO) {
        Notice notice = modelMapper.map(noticeDTO, Notice.class);
        Long bno = noticeRepository.save(notice).getNo_cd();
        return bno;
    }

    @Override
    public NoticeDTO read(Long no_cd) {
        Optional<Notice> result = noticeRepository.findById(no_cd);
        Notice notice = result.orElseThrow();
        NoticeDTO noticeDTO = modelMapper.map(notice, NoticeDTO.class);

        return noticeDTO;
    }

    @Override
    public void update(NoticeDTO noticeDTO) {
        Optional<Notice> result = noticeRepository.findById(noticeDTO.getNo_cd());
        Notice notice = result.orElseThrow();
        notice.changeTitleAndContent(noticeDTO.getNo_title(),noticeDTO.getNo_content());
        // 적용하기.
        noticeRepository.save(notice);
    }

    @Override
    public void delete(Long no_cd) {
        // 레스트 방식일 때는 , 유효성 체크해서 없다는 메세지 전달해줘야 함.
//    Optional<Notice> result = noticeRepository.findById(bno);
//    Notice notice = result.orElseThrow();
        noticeRepository.deleteById(no_cd);
    }

    @Override
    public Notice_PageResponseDTO<NoticeDTO> list(Notice_PageRequestDTO notice_pageRequestDTO) {
//        String[] types = notice_pageRequestDTO.getTypes();
//        String keyword = notice_pageRequestDTO.getKeyword();
//        Pageable pageable = notice_pageRequestDTO.getPageable("bno");
//        // 검색어, 페이징 처리가 된 결과물 10개.
//        // VO
//        Page<Notice> result = noticeRepository.searchAll(types,keyword,pageable);
//        // Entity(VO) -> DTO
//        List<NoticeDTO> dtoList = result.getContent().stream()
//                .map(notice -> modelMapper.map(notice,NoticeDTO.class))
//                .collect(Collectors.toList());
//
//        // 서버 -> 화면에 전달할 준비물 준비 작업 완료.
//        // 1)페이지 2) 사이즈 3) 전쳇갯수 4) 검색 결과 내역10개(엔티티-> DTO)
//        Notice_PageResponseDTO notice_pageResponseDTO = Notice_PageResponseDTO.<NoticeDTO>withAll()
//                .notice_pageRequestDTO(notice_pageRequestDTO)
//                .dtoList(dtoList)
//                .total((int) result.getTotalElements())
//                .build();
//        //test
//
//        return notice_pageResponseDTO;
        return null;
    }

    @Override
    public Notice_PageResponseDTO<NoticeListReplyCountDTO> listWithReplyCount
            (Notice_PageRequestDTO notice_pageRequestDTO) {
//        String[] types = pageRequestDTO.getTypes();
//        String keyword = pageRequestDTO.getKeyword();
//        Pageable pageable = pageRequestDTO.getPageable("bno");
//
//        // 댓글 갯수를 포함한 목록을 가져오기.
//        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types,keyword,pageable);
//        // BoardListReplyCountDTO 변환 할 필요가 일단 없다.
//
//        // 서버 -> 화면에 전달할 준비물 준비 작업 완료.
//        // 1)페이지 2) 사이즈 3) 전쳇갯수 4) 검색 결과 내역10개(엔티티-> DTO)
//        PageResponseDTO pageResponseDTO = PageResponseDTO.<BoardListReplyCountDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(result.getContent())
//                .total((int) result.getTotalElements())
//                .build();

        return null;
    }
}
