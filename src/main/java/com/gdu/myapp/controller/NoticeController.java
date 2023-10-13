package com.gdu.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.dto.NoticeDto;
import com.gdu.myapp.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor 
@Controller
public class NoticeController {

  
  private final NoticeService noticeService;
  
  
  
  @RequestMapping(value="/notice/add.do", method=RequestMethod.POST)
  public String add(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int addResult = noticeService.add(noticeDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  
  
  
  

  
  
}
