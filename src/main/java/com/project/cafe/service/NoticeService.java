package com.project.cafe.service;

import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticeListReplyCountDTO;
import com.project.cafe.dto.Notice_PageRequestDTO;
import com.project.cafe.dto.Notice_PageResponseDTO;

public interface NoticeService {
    Long register(NoticeDTO noticeDTO);
    NoticeDTO read(Long no_cd);
    void update(NoticeDTO noticeDTO);
    void delete(Long no_cd);

    // 화면에서, 사용자가, 현재 페이지 12, 사이지 : 10개 씩 보고
    // 검색어가 존재하고, 타입도 있고,
    Notice_PageResponseDTO<NoticeDTO> list(Notice_PageRequestDTO notice_pageRequestDTO);
    //댓글 숫자 포함해서 목록 출력하기.
    Notice_PageResponseDTO<NoticeListReplyCountDTO> listWithReplyCount(Notice_PageRequestDTO notice_pageRequestDTO);
}
