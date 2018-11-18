<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@page import="kr.or.ddit.user.model.UserVo"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<!-- library -->
<tiles:insertAttribute name="basicLib"></tiles:insertAttribute>

<title>Spring Board</title>
</head>

<body>
	<!-- header -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<tiles:insertAttribute name="left"></tiles:insertAttribute>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
				<!-- contents -->
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
				
			</div>
		</div>
	</div>
	
</body>
</html>
