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
    fnAddResult();
    fnDeleteResult();
  })
  
  function fnAddResult(){
    var addResult = '${addResult}';
    if(addResult !== ''){
      if(addResult === '1'){
        alert('공지사항이 등록되었습니다.');
      } 
  }
   }
 
  
  
</script>
</head>
<body>

<div id="mainWrap">

<div><h2>고양이 상사에 오신 걸 환영합니다</h2></div>

 <img src="${contextPath}/resources/images/animal10.jpg" width="192px">


<hr>

<table border="1">
<thead>
<tr>
<td>공지번호</td>
<td >제목</td>

</tr>
</thead>
<tbody id="list">

  <c:forEach items="${noticeList}" var="item">
          <tr>
            <td>${item.notice_no}</td>   
            <td><a href="${contextPath}/notice/detail.do">${item.title}</a></td>
          </tr>
 </c:forEach>

</tbody>

</table>







<hr>






<a href="${contextPath}/notice/write.do">새로운 공지 작성하러 가기</a>

</div>

</body>
</html>