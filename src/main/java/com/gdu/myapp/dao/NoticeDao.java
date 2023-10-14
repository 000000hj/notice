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
  

}
