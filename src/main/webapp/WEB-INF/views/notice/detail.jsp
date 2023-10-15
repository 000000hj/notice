<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

  $(function(){
  	fnModify()
    fnDelete();
    fnList();
   
  })
  
  
  function fnModify(){
  	$('#btn_modify').click(function(){
  		$('#mainWrap').children().remove();
  		$('#mainWrap').append('<div><span>←뒤로가기</span></div><div><h1>공지사항 편집하기</h1></div> <form   method="post" action="${contextPath}/notice/modify.do"><div><label for="gubun" >구분</label><select id="gubun" name=gubun value="${notice.gubun}"><option   value="1" id="gubun">긴급</option><option   value="2" id="gubun" >일반</option></select></div>  <div><label for="title">제목</label><input type="text" id="title" name="title" value=${notice.title}></div><div><div>내용</div> <textarea rows="5" cols="30" value=${notice.content} name="content" id="content"></textarea></div><div> <button type="submit">편집완료</button> <button type="button" id="btn_list">목록</button>        </div>      </form>'); 		  		
  	
  	
  	})
  	
  	fnModifyResult();
  }
  


  function fnModifyResult(){
   	
    var modifyResult = '${modifyResult}';
    if(modifyResult !== ''){
      if(modifyResult === '1'){
        alert('연락처가 수정되었습니다.');
      } else {
        alert('연락처 수정이 실패했습니다.');
      }
    }
  }
  
  function fnDelete(){
  $('#btn_delete').click(function(){
    if(confirm('연락처를 삭제할까요?')){
    	$('#frm_detail').attr('action', '${contextPath}/notice/delete.do');
	    $('#frm_detail').submit();
    }
  })
  }

  function fnList(){
  $('#btn_list').click(function(){
  	
    location.href = '${contextPath}/notice/list.do';
  })
  }
  
  
  
  
  
</script>
</head>
<body>




<div id="mainWrap">

<h1> ${notice.notice_no}  번 공지사항 </h1>
<div> 구분: <c:set var="gubun" value="${notice.gubun}"/>
            <c:if test="${gubun==1}">긴급</c:if>
            <c:if test="${gubun==2}">일반</c:if>
            </div>
<div> 제목: ${notice.title}</div>
<div>${notice.content}</div>




<hr>
<div>
<button type="button" id="btn_modify">편집</button>
<button type="button" id="btn_delete">삭제</button>
<button type="button" id="btn_list">목록</button>
</div>

</div>

</body>
</html>