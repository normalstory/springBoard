<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css"> 
	select { height: 26px; } 
	.userClick { cursor: pointer; } 
	.menuList{ background-color: #fffddd; }
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$(".addBoard").on("click", function(){
			var boardManager = $("#addBoardParam").children(".addPan").eq(0).val();
			$("#boardname").val(boardManager);
			boardManager = $("#addBoardParam").children(".addPan").eq(1).val();
			$("#boarddel").val(boardManager);
			$("#pan_Case").val("add");
			$("#frm").submit();
		});
		 
		$(".updateBoardParam").on("click","#saveMenu", function(){
			var boardManager = $(this).parent()[0].children[1].value
			$("#boardname").val(boardManager);
			boardManager = $(this).parent()[0].children[2].value
			$("#boarddel").val(boardManager);
			$("#pan_Case").val("update");
			boardManager = $(this).parent()[0].children[3].value
			$("#boardid").val(boardManager);
			$("#frm").submit();
		});
		
	});	
</script>

<div class="blog-post">
	<h2 class="blog-post-title">BoardManager</h2>
	<p>게시판을 관리하는 페이지 입니다.</p>
	<hr>

	<h3>게시판 목록</h3>
	<span>신규 생성하기</span>
	<ul> 
		<li id="addBoardParam" >
			<input class="addPan" type="text" name="addboardname" placeholder="생성할 게시판 이름 기재~" /> 
			<select class="addPan" name="addboarddel" >
					<option value="y">사용</option>
					<option value="x">안사용</option>
			</select> 
			<button type="button" class="addBoard">등록</button>
		</li>
	</ul>
	<br/>
	
	<!-- parameter sender -->
	<span>운영 게시판 목록</span>
	<form id="frm" action="/boardSet" method="post">
		관리자 : <input type="text" name="userid" value="${uservo.userid}">
		<input id="boardid" type="hidden" name="boardid" >
		<input id="pan_Case" type="hidden" name="boarddel" >
		
		<ul class="updateBoardParam" >
			<c:forEach items="${boardList }" var="board" varStatus="i">
				<li >
					<input type="hidden" name="boardid" value="${board.boardid }" />
					<input type="text" name="boardname" value="${board.boardname }" 
						<c:if test="${board.boarddel=='y'}">class="menuList"</c:if>
					 /> 
					<select name="boardUse">
							<option value="y"
								<c:if test="${board.boarddel=='y'}">selected</c:if>>사용</option>
							<option value="n"
								<c:if test="${board.boarddel=='n'}">selected</c:if>>안사용</option>
					</select>
				</li>
			</c:forEach>
		</ul>
	</form>
</div>