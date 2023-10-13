package com.gdu.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

  @RequestMapping(value = "/" ,method = RequestMethod.GET )
  public String index() {
    return "index";
  }
  
  
  @RequestMapping(value = "notice/list.do",method = RequestMethod.GET)
   public String list() {
    
     return "notice/list";
   } 
  
  
  @RequestMapping(value = "notice/write.do",method = RequestMethod.GET)
  public String write() {
   
    return "notice/write";
  } 
  
  
  
  
}
