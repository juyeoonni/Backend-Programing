<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script>

//이런 함수는 이름 정하고 선언해준거 그래서 호출을 통해 실행해야해 
// showReplyList()함수는 서버에 ajax 요청을 보내어 댓글 데이터를 가져온 후, 성공 시 데이터를 처리하고 페이지 표시.
// 실패 시 오류를 처리하는 역할
// -> 이를 통해 동적으로 업데이트 하여 페이지에 표시하는 동작이 이루어짐 
function showReplyList(){
   // ajax를 사용해서 서버에서 댓글의 목록을 가져와 페이지에 표시하는 역할 (페이지 로드시 댓글을 표시하는데 사용)
	// 1. ajax reply list select
   // 2. 화면에 보여주는 작업 
   
   $.ajax({
      url : '${pageContext.request.contextPath}/reply/${boardVO.no}',
      method : 'get',
      success : function(data){ //ReplyVO list
         alert('showReplyList 성공');
         console.log(data);
         console.log(typeof data);
         $('#replyList').empty();
         $(data).each(function(){
            str='<hr>';
            str += '<strong>'+this.content +'</strong>'; 
            str += '&nbsp;' + this.writer; + '&nbsp;';
            str += '&nbsp;' + this.regDate + '&nbsp;';
            str += '<button class="delBtn" id= ' + this.no +' />삭제</button>'
             
            $('#replyList').append(str)
         })
      },
      error : function(){
         alert('showReplyList 실패')
      },
      
   })
}


$(document).ready(function(){
   //이 아래 내용들을 다 하는거지 실행하면 
   showReplyList();
   //이건 익명함수, 그냥 선언과 동시에 바로 실행시키는거야 
   
   // deleteAjax
   $(document).on('click','.delBtn',function(){
		
		let replyNo = $(this).attr('id');
		$.ajax({
			url : '${pageContext.request.contextPath}/reply/${boardVO.no}/' + replyNo,
			method : 'delete',
			success : function(){
				showReplyList();
			} ,
			error : function(){
				alert('delete 실패')
			}	
		})
	})
	
   
   
   //이건 정적으로 만들어서 이게 되는거야 
   $('#replyAddBtn').click(function(){
      alert('클릭 성공')
      //reply insert를 여기서 할 것
      
      let replyContent = document.replyForm.content.value;
      let replyWriter = document.replyForm.writer.value;
      
      $.ajax({
         url :  '${pageContext.request.contextPath}/reply'     ,
         method :   'post',
         data:  {
            boardNo : ${boardVO.no},
            content: replyContent,
            writer:  replyWriter
            
         },
         success:     function(){
            alert('insert성공');
            document.replyForm.content.value="";
            document.replyForm.writer.value="";
            showReplyList();
         },
         error:       function(){
            alert('insert실패')
         }
      })
   })
})

</script>
</head>
<body>
<a href="${pageContext.request.contextPath}/"><img alt="" src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png"></a>
<a href="${pageContext.request.contextPath}/board">게시판</a>
<a href="${pageContext.request.contextPath}/board/new">글쓰기</a>
    <c:if test="${empty currentUser }">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
    </c:if>
    <c:if test="${not empty currentUser }">
        ${currentUser.name }님 안녕하세요.<br>
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
    </c:if>
<a href="${pageContext.request.contextPath}/join">회원가입</a>

   상세게시글입니다.

   <div align="center">
      <table border="1" width="60%">
         <tr>
            <th>번호</th>
            <td>${boardVO.no }</td>
         </tr>
         <tr>
            <th>제목</th>
            <td>${boardVO.title }</td>
         </tr>
         <tr>
            <th>글쓴이</th>
            <td>${boardVO.writer}</td>
         </tr>
         <tr>
            <th>등록일</th>
            <td>${boardVO.regDate }</td>
         </tr>
         <tr>
            <th>내용</th>
            <td>${boardVO.content}</td>
         </tr>
         <tr>
            <th>조회수</th>
            <td>${boardVO.count }</td>
         </tr>
      </table>
      <input type="button" value="Home" onclick="location.href='${pageContext.request.contextPath}/'">
      <input type="button" value="목록으로" onclick="location.href='${pageContext.request.contextPath}/board'">
      <input type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/'">
   </div>
<!--    정적으로 있는거야 이건 그래서 click 되는거고 아깐 str 안에 넣어서 동적으로 만들어준거야 그때그때 그래서 on 메소드,  -->
   <div>
      <form name="replyForm">
          댓글: <input type= "text" size="80" name="content">
          작성자: <input type = "text" size ="20" name ="writer">
          <input type="button" value="댓글쓰기" id="replyAddBtn">
      </form>      
   </div>

    <div id="replyList">
        
    </div>   
</body>
</html>