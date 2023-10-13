package com.gdu.myapp.service;

import java.util.List;

import com.gdu.myapp.dto.NoticeDto;

public interface NoticeService {

public int add(NoticeDto noticeDto);
public int modify(NoticeDto noticeDto);
public int delete(int notice_no);
public List<NoticeDto> getList();
public NoticeDto getNoticeByNo(int notice_no);
  
}
