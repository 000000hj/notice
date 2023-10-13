package com.gdu.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.myapp.dto.NoticeDto;

@Repository
public class NoticeDao {

  @Autowired  // Spring Container에 저장된 JdbcConnection 타입의 객체(Bean)을 가져온다.
  private JdbcConnection jdbcConnection;
  
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  
  //삽입
  
 public int insert(NoticeDto noticeDto) {
    
    int insertCount = 0;
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "INSERT INTO NOTICE_T(NOTICE_NO, GUBUN, TITLE, CONTENT) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
      ps = con.prepareStatement(sql);
      ps.setInt(1, noticeDto.getNotice_no());
      ps.setInt(2, noticeDto.getGubun());
      ps.setString(3, noticeDto.getTitle());
      ps.setString(4, noticeDto.getContent());
      insertCount = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    return insertCount;
    
  }
  
  // 수정
  
  
 
  //삭제
  
  
  //전체 조회
  public List<NoticeDto> selectList() {
    
    List<NoticeDto> list = new ArrayList<NoticeDto>();
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T ORDER BY NOTICE_NO ASC";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setNotice_no(rs.getInt("NOTICE_NO"));
        noticeDto.setTitle(rs.getString("TITLE"));
        list.add(noticeDto);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    return list;
    
  }
  
  
  //상세조회
 public NoticeDto selectNoticeByNo(int notice_no) {
    
   NoticeDto noticeDto = null;
    
    try {
      
      con = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      rs = ps.executeQuery();
      if(rs.next()) {
        noticeDto = new NoticeDto();
        noticeDto.setNotice_no(rs.getInt(1));
        noticeDto.setGubun(rs.getInt(2));
        noticeDto.setTitle(rs.getString(3));
        noticeDto.setContent(rs.getString(4));
  
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    return noticeDto;
    
  }
  
  
}
