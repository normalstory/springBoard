<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
	.heightFix { height: 29em; }
</style>

<!-- 스마트 에디터 -->
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	var count;
	$(document).ready(function() {
		count=1;
		//첨부파일 - 버튼 추가
		$("#buttonAdd").on("click", function(){
			if(count<6){
				$("#addDirBt").append("<input type='file' name='uploadFile"+count+"'' >");
				$("#addDirBtCnt").val(count);
			}else{
				alert("최대 5개의 파일만 첨부할 수 있습니다.")
			}
			count++;
		});
	})
	
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", //*** 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(
	function() {
		if (confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			// exec("UPDATE_CONTENTS_FIELD", []) <- html로 보내는 것 
			oEditors.getById["smarteditor"].exec(
					"UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if (validation()) {
				$("#frm").submit();
			}
		}
	});
});

// 필수값 Check
function validation() {
	var contents = $.trim(oEditors[0].getContents());
	if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}
	return true;
}
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<form role="form" action="/textEditer" method="post" id="frm" enctype="multipart/form-data">
			<input type="hidden" name="useriId" value="${userid }">
			<input type="hidden" name="boardid"  value="${boardVo.boardid  }">

			${boardVo.boardname }게시판 &#187; <br/>
			<h2 class="sub-header"><input type="text" name="texttitle" placeholder="글 제목을 작성해주세요"></h2>
			<div class="table-responsive">
				<div class="form-group">
					<textarea name="smarteditor" id="smarteditor" ></textarea>
				</div>
			</div>
			<div class="table-responsive">
				<a class="btn btn-default pull-left" id="buttonAdd" >첨부파일 추가</a><br>
				<div class="form-group">
					<input type="hidden" id="addDirBtCnt" name="addDirBtCnt" >
					<div class="col-sm-10" id="addDirBt" >
						 
					</div>
				</div>
			</div>
		<a class="btn btn-default pull-right" id="savebutton" >저장</a>
		</form>
		
	</div>
</div>
