package com.gdu.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

 
  private final NoticeDao noticeDao;
  
  
  //목록 가져오기 기능 구현
  // 목록을 조회하기 때문에 list로 반환
  @Override
  public List<NoticeDto> getNoticeList() {
    //dao의 리스트 결과같을 받아서 컨트롤러로 전달해
    return noticeDao.selectList() ;
  }
  
  
@Override
  public int addNotice(NoticeDto noticeDto) {
  
  int addResult=noticeDao.insert(noticeDto);
  
  
    return addResult;
  }



//상세조회
@Override
public NoticeDto getNoticeByNo(int notice_no) {

  return noticeDao.select(notice_no);
}


// 선택한 글삭제(글번호) 
@Override
public int deleteNotice(int notice_no) {

  int deleteResult=noticeDao.delete(notice_no);
  
  
  return deleteResult;
}
}
