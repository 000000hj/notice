package com.gdu.myapp.service;

import java.util.List;

import com.gdu.myapp.dto.NoticeDto;

public interface NoticeService {

  
  
  //리스트 가져와!
 public List<NoticeDto>getNoticeList();
 public int addNotice(NoticeDto noticeDto);
 public NoticeDto getNoticeByNo(int notice_no);
}
