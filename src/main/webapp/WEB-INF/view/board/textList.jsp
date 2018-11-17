<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<style type="text/css">
.heightFix {
	/* height: 420px; */
	height: 29em;
}
.userClick {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var ec="click"
		$(".textClick").on(ec,function(){
			var textNum = $(this).children()[0].innerText;
			$("#textNum").val(textNum);
			$("#frm").submit();
		});

		$("#searchClick").on(ec,function(){
			var Keyword = $(this).prev().val();
			alert(Keyword);
			$("#searchKeyword").val(Keyword);
			$("#search").submit();
		});
	});	
</script>

<form id="frm" action="/textDetail" method="get">
	<input type="hidden" id="textNum" name="textnum">
	<input type="hidden" id="boardid" name="boardid" value="${boardVo.boardid }">
</form>
<div class="row">
<div class="col-sm-8 blog-main">
	<h2 class="sub-header">${boardVo.boardname } || ${pageVo.search }</h2>

	<div class="table-responsive heightFix">

		<table class="table table-striped table-hover">
			<tr>
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성자아이디</th>
				<th>작성일시</th>
			</tr>
			
			<!-- panList loop 출력 -->
			<c:forEach items="${textList}" var="textVo" >
			<tr class="textClick" >
				<td>${textVo.textnum }</td>
				<td>${textVo.t }</td>
				<td>${textVo.userid }</td>
				<td><fmt:formatDate value="${textVo.textbirth }" pattern="yyyy-MM-dd HH:MM"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<a class="btn btn-default pull-right" href="/textEditerView?userid=${uservo.userid}&boardid=${boardVo.boardid }">새글 등록</a>

	<div class="text-left">
		<form id="search" action="/textList" method="get">
			<input type="text" id="searchKeyword" name="search" placeholder="게시글 제목 검색">
			<a  id="searchClick" class="btn btn-default">검색</a>
			<input type="hidden" name="page" value="1">
			<input type="hidden" name="pageSize" value="10">
			<input type="hidden" name="boardid" value="${boardVo.boardid }">
		</form>
	</div>

	<div class="text-center">
		<ul class="pagination">
			<li><a href="/textList?page=1&pageSize=10&boardid=${boardVo.boardid }" aria-label="PreviousFloor"> 
			<span aria-hidden="true">&#8676;</span></a></li>
			
			<c:if test="${pageVo.page!=1}">
				<li><a href="/textList?page=${pageVo.page-1}&pageSize=10&boardid=${boardVo.boardid }" aria-label="PreviousFloor"> 
				<span aria-hidden="true">&#8592;</span></a></li>
			</c:if>
			
			<c:forEach begin="1" end="${pageNum }" var="p">
				<li><a href="/textList?page=${p}&pageSize=10&boardid=${boardVo.boardid }">${p}</a></li>
			</c:forEach>
			
			<c:if test="${pageVo.page!=pageNum}">   
				<li><a href="/textList?page=${pageVo.page+1}&pageSize=10&boardid=${boardVo.boardid }" aria-label="NextFloor"> 
				<span aria-hidden="true">&#8594;</span></a></li>
			</c:if>
			
			<li><a href="/textList?page=${pageNum }&pageSize=10&boardid=${boardVo.boardid }" aria-label="NextFloor"> 
				<span aria-hidden="true">&#8677;</span></a></li> 
			</ul>
		</div>
	</div>
</div>


							