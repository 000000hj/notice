package com.gdu.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.dto.NoticeDto;
import com.gdu.myapp.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor  // final로 bean 객체 읽을시 명시
public class NoticeController {

  private final NoticeService noticeService;
  
  
  /*리스트 보여줘*/
  // 이 요청주소를 받으면 할일들
  @RequestMapping(value = "/notice/list.do", method = RequestMethod.GET)
  public String list(Model model) // 나는 스트링으로 반환할거여
  {
   List<NoticeDto> noticeList= noticeService.getNoticeList();// 서비스한테 시켜
   model.addAttribute("noticeList",noticeList);//서비스한테 받은 정보 모델에 저장
   
   // 로그 찍어
   log.info(noticeList.toString());
   
   
   //실제  반환할 주소 값
   return "notice/list";
  }
  
  
  
  
  
  /*글작성으로 이동*/
  
  //작성하러 가기
  @RequestMapping(value = "/notice/write.do",method = RequestMethod.GET)
  public String write()
  {
    return "/notice/write";
  }
  
  
  
  
  
  
  /*글 등록 완료*/
  //리스트에 삽입
  @RequestMapping(value = "/notice/add.do",method = RequestMethod.POST)
  public String add(NoticeDto noticeDto,RedirectAttributes redirectAttributes) {
  int addResult=noticeService.addNotice(noticeDto);
  redirectAttributes.addAttribute("addResult",addResult);
  return "redirect:/notice/list.do";
  }
  
  
  
  /*글 상세 보기 */
  @RequestMapping(value = "/notice/detail.do",method = RequestMethod.GET) 
  //요청 요청파라미터는 필수가 아니고 , 값이 없다면 0으로 처리할거야. 이 값은 notice_no 라고 부를거야.
  public String detail(@RequestParam(value = "notice_no", required = false , defaultValue = "0") int notice_no,Model model) {
   //notice_no를 전달해 받아온 notice 객체하나를 모델에 저장
    
    model.addAttribute("notice",noticeService.getNoticeByNo(notice_no));
    
    return "notice/detail";
  }
  
  
  
  
  
}
