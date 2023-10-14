package com.gdu.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

  private int notice_no;
  private int gubun;
  private String title;
  private String content;
  
}
