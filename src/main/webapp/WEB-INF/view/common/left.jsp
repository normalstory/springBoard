<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"> <a href="/boardSetView">게시판 메뉴관리</a></li>	
		<li class="active"> <a href="/textEditer">게시글 쓰기</a></li>	
		<c:forEach items="${boardManu }" var="board">
			<li >
				${board.boardname }
			</li>
		</c:forEach>
	</ul>
	
</div>