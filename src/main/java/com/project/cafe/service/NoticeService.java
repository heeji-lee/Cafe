package com.project.cafe.service;

import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticePageRequestDTO;
import com.project.cafe.dto.NoticePageResponseDTO;

public interface NoticeService {
//    Long register(NoticeDTO noticeDTO);
    NoticeDTO read(Long cd);
//    void update(NoticeDTO noticeDTO);
//    void delete(Long no_cd);

    // 화면에서, 사용자가, 현재 페이지 12, 사이지 : 10개 씩 보고
    // 검색어가 존재하고, 타입도 있고,
    NoticePageResponseDTO<NoticeDTO> list(NoticePageRequestDTO noticepageRequestDTO);

}
