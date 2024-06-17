package com.project.cafe.controller;

import com.project.cafe.dto.NoticeDTO;
import com.project.cafe.dto.NoticeListReplyCountDTO;
import com.project.cafe.dto.Notice_PageRequestDTO;
import com.project.cafe.dto.Notice_PageResponseDTO;
import com.project.cafe.service.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cafe/notice")
@Log4j2
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/list")
    public void list(Notice_PageRequestDTO notice_pageRequestDTO, Model model) {

//        log.info("BoardController : /board/list  확인 중, pageRequestDTO : " + pageRequestDTO);

        Notice_PageResponseDTO<NoticeListReplyCountDTO> responseDTO
                = noticeService.listWithReplyCount(notice_pageRequestDTO);
        // 서버로부터 응답확인.
//        log.info("BoardController 확인 중, responseDTO : " + responseDTO);
        // 서버 -> 화면 데이터 전달.
        model.addAttribute("responseDTO", responseDTO);

    } //list 닫는 부분

    //글쓰기 폼
    @GetMapping("/register")
    public void registerForm() {
    }

    //글쓰기 처리
    @PostMapping("/register")
    public String register(@Valid NoticeDTO noticeDTO
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model) {
        // 입력중 유효성 체크에 해당 될 때
        if(bindingResult.hasErrors()) {
            log.info("register 중 오류 발생.");
            redirectAttributes.addFlashAttribute(
                    "errors", bindingResult.getAllErrors());
            return "redirect:/cafe/notice/register";
        }
        log.info("화면에서 입력 받은 내용 확인 : " + noticeDTO);

        //화면 -> 서버 -> 서비스 -> 레포지토리 -> 디비, 입력후, 게시글 번호 가져오기
        //화면 <- 서버 <- 서비스 <- 레포지토리 <- 디비
        Long bno = noticeService.register(noticeDTO);

        // 글쓰기 후, 작성된 게시글 번호 -> 화면 , 임시로 전달.(1회용)
        redirectAttributes.addFlashAttribute("result",bno);
        redirectAttributes.addFlashAttribute("resultType","register");
        return "redirect:/cafe/notice/list";

    }

    //하나 조회 = 상세화면, read
    // 준비물, 해당 게시글 번호로 조회한 데이터가 필요함.
    // 화면 -> 서버로 , bno 게시글 번호를 전달하기.
    @GetMapping({"/read","/update"})
    public void read(Long bno, Notice_PageRequestDTO notice_pageRequestDTO, Model model) {

        log.info("BoardController : /cafe/notice/read  확인 중, notice_pageRequestDTO : " + notice_pageRequestDTO);

        // 디비에서, bno 번호, 하나의 게시글 디비 정보 가져오기.
        NoticeDTO noticeDTO = noticeService.read(bno);
        // 서버로부터 응답확인.
        log.info("NoticeController 확인 중, noticeDTO : " + noticeDTO);
        // 서버 -> 화면 데이터 전달.
        model.addAttribute("noticeDTO", noticeDTO);

    } //read 닫는 부분

    //글수정 처리
    @PostMapping("/update")
    public String update(@Valid NoticeDTO noticeDTO
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model
            ,Notice_PageRequestDTO notice_pageRequestDTO) {
        // 입력중 유효성 체크에 해당 될 때
        if(bindingResult.hasErrors()) {
            log.info("update 중 오류 발생.");
            redirectAttributes.addFlashAttribute(
                    "errors", bindingResult.getAllErrors());
            // 서버 -> 화면으로 쿼리 스트링으로전달.
            // 예시 : ?bno=게시글번호
            redirectAttributes.addAttribute("bno", noticeDTO.getNo_cd());
            return "redirect:/cafe/notice/update"+notice_pageRequestDTO.getLink();
        }
        log.info("화면에서 입력 받은 내용 update 확인 : " + noticeDTO);

        //화면 -> 서버 -> 서비스 -> 레포지토리 -> 디비, 입력후, 게시글 번호 가져오기
        //화면 <- 서버 <- 서비스 <- 레포지토리 <- 디비
        noticeService.update(noticeDTO);

        // 글쓰기 후, 작성된 게시글 번호 -> 화면 , 임시로 전달.(1회용)
        redirectAttributes.addFlashAttribute("result",noticeDTO.getNo_cd());
        redirectAttributes.addFlashAttribute("resultType","update");

        return "redirect:/cafe/notice/list?"+notice_pageRequestDTO.getLink2();

    }

    //글삭제 처리
    @PostMapping("/delete")
    public String delete(Notice_PageRequestDTO notice_pageRequestDTO, Long bno, RedirectAttributes redirectAttributes
    ) {
        //화면 -> 서버 -> 서비스 -> 레포지토리 -> 디비, 입력후, 게시글 번호 가져오기
        //화면 <- 서버 <- 서비스 <- 레포지토리 <- 디비
        noticeService.delete(bno);

        // 글쓰기 후, 작성된 게시글 번호 -> 화면 , 임시로 전달.(1회용)
        redirectAttributes.addFlashAttribute("result",bno);
        redirectAttributes.addFlashAttribute("resultType","delete");
        return "redirect:/cafe/notice/list?"+notice_pageRequestDTO.getLink2();

    }

}