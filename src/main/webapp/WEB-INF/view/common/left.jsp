<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"> <a href="/main.jsp">Main <span class="sr-only">(current)</span> </a></li>
		<li class="active"> <a href="/boardPanManager">게시판 메뉴관리							</a></li>	
		<li class="active"> <a href="/filter/requestCounterFilter.jsp">게시판 통계관리			</a></li>	
		<li class="active"> <a href="/mvpTrello">MVP Modeling								</a></li>	
		
	</ul>
	
	
	<c:forEach items="${panListManu }" var="board">
		<li class="active">
			<a href="/boardTextList?page=1&pageSize=10&panId=${board.panId }&panName=${board.panName }">${board.panName }</a>
		</li>
	</c:forEach>
</div>