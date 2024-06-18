package com.project.cafe.controller;

import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticePageRequestDTO;
import com.project.cafe.dto.NoticePageResponseDTO;
import com.project.cafe.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cafe/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/list")
    public String list(NoticePageRequestDTO noticepageRequestDTO, Model model) {
        NoticePageResponseDTO<NoticeDTO> responseDTO
                = noticeService.list(noticepageRequestDTO);

        // 서버 -> 화면 데이터 전달.
        model.addAttribute("responseDTO", responseDTO);

        // 화면 이름 반환
        return "cafe/notice/list"; // notice 폴더 아래 list.html 파일을 참조하도록 설정
    }

    //하나 조회 = 상세화면, read
    // 준비물, 해당 게시글 번호로 조회한 데이터가 필요함.
    // 화면 -> 서버로 , bno 게시글 번호를 전달하기.
    @GetMapping({"/read"})
    public String read(@RequestParam("cd") Long cd, Model model) {

        // 디비에서, bno 번호, 하나의 게시글 디비 정보 가져오기.
        NoticeDTO noticeDTO = noticeService.read(cd);

        // 서버 -> 화면 데이터 전달.
        model.addAttribute("noticeDTO", noticeDTO);
        return "cafe/notice/read";
    } //read 닫는 부분

}