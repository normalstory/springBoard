<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
	.heightFix{ height: 29em;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".saveReply").on("click", function(){
			var saveReply = $("#saveReplyParam").children(".reple").val();
			$("#addReply").val(saveReply);
			$("#frm").submit();
		});
	});

	$("#updateButton").on("click", function(){
		var updateR = $(".updateR").html();
		$(".updateR").remove();
		$("#reReply").append("<input id='addeply' class='reple' name='"+updateR+"'/>");
		$("#addeply").val(updateR);
	});
</script>

<form id="frm" action="/textReply" method="post">
	<input type="hidden" name="userid" value="${userVo.userid}">
	<input id="delReply" type="hidden" name="delReply" >
	<input id="textNum" type="hidden" name="textnum" value="${textVo.textnum }"> 
	<input id="addReply" type="hidden" name="replesubline" >
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		${boardVo.boardname }게시판 &#187; <br/>
		작성자 : ${textVo.userid } | 작성일 : <fmt:formatDate value="${textVo.textbirth }" pattern="yyyy-MM-dd HH:MM"/> 
		<a class="btn btn-default pull-right" 
			href="/boardTextReplyEditer?userId=${userVo.userid}&panId=${boardVo.boardid }&textNum=${textVo.textnum}">답글</a>
		<!-- 접근 권한 제한 : 삭제, 수정 -->
		<c:if test="${userVo.userid==textVo.userid}">
			<a class="btn btn-default pull-right" 
				href="/textUpdateView?textnum=${textVo.textnum}&boardid=${boardVo.boardid }">수정</a>
			<a class="btn btn-default pull-right" 
				href="/textDel?textnum=${textVo.textnum}&boardid=${boardVo.boardid }">삭제</a>
		</c:if>
			
		<h2 class="sub-header">[${textVo.textnum }]  ${textVo.texttitle }</h2>
		<div class="table-responsive">
			<div class="form-group heightFix">
				<div class="col-sm-10">
					<label class="control-label">${textVo.textsubline }</label>
				</div>
			</div>
			
			<div class="form-group">
				<br /> <br /> 
				<label for="userNm" class="col-sm-10 control-label">[ 첨부파일 ] </label>
				<div class="col-sm-10 ">
					<c:forEach items="${fileList }" var="addFile" varStatus="i">
							<span>첨부파일 ${i.count } : ${addFile.addfilename} - </span>  <a href="${addFile.addfilepath}">다운로드</a>
						<br /> 
					</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="table-responsive">
			<div class="form-group">
				<div id="saveReplyParam" class="col-sm-10"><br /> 
					<label for="userNm" >[ 댓글 ]</label> 
					<input type="text" id="addReply" class="reple" name="replesubline" placeholder="댓글을 작성해주세요~">
					<a class="btn btn-default saveReply">등록</a><br />
					<div class="col-sm-10" id="reReply">
						<c:forEach items="${replyList }" var="reply" varStatus="i">
							<label class="control-label updateR">RE ${i.count }) <fmt:formatDate value="${reply.replebirth}" pattern="yyyy-MM-dd HH:MM"/> | ${reply.replesubline} </label>
							<!-- 접근 권한 제한 : 삭제, 수정 -->
							<c:if test="${userVo.userid==textVo.userid}">
								<a class="btn btn-default savebutton" href="/replyDel?repleid=${reply.repleid}&textnum=${textVo.textnum }">삭제</a>
							</c:if>
							<br /> 
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>
    
    