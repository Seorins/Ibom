<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Page Not Found</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet"> <!-- Bootstrap Icons 추가 -->
    <link rel="stylesheet" type="text/css" href="/ibom/resources/css/errorPage.css">
</head>
<body>
    <div class="container">
        <div class="title">
            <h2><i class="bi bi-x-circle"></i>찾을 수 없는 페이지 입니다.</h2>
        </div>
        <div class="content">
   	    	<p>입력하신 페이지의 주소가 잘못 입력되었거나,</p>
   	    	<p>변경 또는 삭제되어 요청하신 페이지를 찾을 수 없습니다.</p>
        	<p>입력하신 주소가 정확한지 다시 한 번 확인해주시기 바랍니다.</p>
        </div>
        <a href="/ibom" class="btn-home">홈으로</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
