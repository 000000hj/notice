package com.gdu.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.myapp.dto.NoticeDto;

//db에 연결후 데이터 주고받는 곳

@Repository
public class NoticeDao {

  
  // jdbc 정보 객체로 만들어야햄
  //db 연결 준비
  @Autowired
  private JdbcConnection jdbcConnection;
  
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  // 삽입 메소드
  public int insert(NoticeDto noticeDto) {
    int insertCount=0;
    
    try {
      con=jdbcConnection.getConnection();
      String sql=  "INSERT INTO NOTICE_T(NOTICE_NO, GUBUN, TITLE, CONTENT) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
     
      ps=con.prepareStatement(sql);
    
      ps.setInt(1, noticeDto.getGubun());
      ps.setString(2, noticeDto.getTitle());
      ps.setString(3, noticeDto.getContent());
      insertCount=ps.executeUpdate();
    
    } catch (Exception e) {
      e.printStackTrace();
    
    }finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    
    return insertCount;
  }
  
  
  // 전체 조회 메서드 
  //dto정보를 담은 리스트 반환
  public List<NoticeDto> selectList(){
    List<NoticeDto>list=new ArrayList<NoticeDto>();
    
    try {
      //연결
      con=jdbcConnection.getConnection();
      //돌릴 sql
      String sql="SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T ORDER BY NOTICE_NO DESC";
      // 실행 준비
      ps=con.prepareStatement(sql);
      // 실행
      rs=ps.executeQuery();
      
      // 다음 행이 존재한다면 반복 
      while(rs.next()) {
        
        //dto에 각 쿼리문 조회 결과  값 넣기.
        NoticeDto noticeDto=new NoticeDto();
        noticeDto.setNotice_no(rs.getInt("NOTICE_NO"));
        noticeDto.setGubun(rs.getInt("GUBUN"));
        noticeDto.setTitle(rs.getString("TITLE"));
        noticeDto.setContent(rs.getString("CONTENT"));
        
        //조회결과중 하나의 행을 리스트에 넣기
        list.add(noticeDto);
        
         
      }
      
    } catch (Exception e) {

    e.printStackTrace();
    
    }finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    // 만들어진 리스트 반환 즉 . 조회한 목록 전체 반환
    return list;
  }
  
  
  //상세조회
  public  NoticeDto select(int notice_no)
  {
    NoticeDto noticeDto=null;
    
    
    try {
      con=jdbcConnection.getConnection();
      String sql="SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T WHERE NOTICE_NO = ? " ;
      ps=con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      rs=ps.executeQuery();
      
      if(rs.next())
      {
        
        noticeDto=new NoticeDto();
        noticeDto.setNotice_no(rs.getInt(1));
        noticeDto.setGubun(rs.getInt(2));
        noticeDto.setTitle(rs.getString(3));
        noticeDto.setContent(rs.getString(4));
      }
      
      
    } catch (Exception e) {

    e.printStackTrace();
    }finally {
      jdbcConnection.close(con, ps, rs);
    }
    
    
    
    return noticeDto;
    
  }
  
}
