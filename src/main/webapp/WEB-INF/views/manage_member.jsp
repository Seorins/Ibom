<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.springmvc.domain.member" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 관리</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/ibom/resources/css/manage_member.css">
    <style>
        /* 테이블 행 Hover 효과 추가 */
        .table tbody tr:hover {
            background-color: #f1e6e0; /* Hover 시 색상 */
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h4>Menu</h4>
        <a href="/ibom/manage">전체 회원 관리</a>
    </div>
    <div class="content">
        <div class="container">
            <h1 class="text-center">Member 	Management</h1>
                <div class="input-group mb-4">
                    <input type="text" class="form-control" id="search" name="searchName" placeholder="회원 이름으로 검색" aria-label="회원 이름으로 검색">
                </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>생년월일</th>
                        <th>폰번호</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<member> mb = (List<member>)request.getAttribute("member");
                        if (mb != null) {
                            for (member member : mb) {
                    %>
                        <tr>
                            <td><%= member.getId() %></td>
                            <td><%= member.getName() %></td>
                            <td><%= member.getBirth() %></td>
                            <td><%= member.getPhone() %></td>
                        </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
                <div class="pagination">
				    <%
					    Integer currentPage = (Integer) request.getAttribute("currentPage");
					    Integer totalPages = (Integer) request.getAttribute("totalPages");
	
					    // 페이지 번호와 총 페이지 수가 null인지 확인
					    if (currentPage == null) currentPage = 1;
					    if (totalPages == null) totalPages = 1;				        
				    %>
				    <nav aria-label="Page navigation">
				        <ul class="pagination">
				            <li class="page-item <%= (currentPage == 1) ? "disabled" : "" %>">
				                <a class="page-link" href="?page=<%= currentPage - 1 %>" aria-label="Previous">
				                    <span aria-hidden="true">&laquo;</span>
				                </a>
				            </li>
				            <%
				                for (int i = 1; i <= totalPages; i++) {
				                    String activeClass = (i == currentPage) ? "active" : "";
				            %>
				            <li class="page-item <%= activeClass %>">
				                <a class="page-link" href="?page=<%= i %>"><%= i %></a>
				            </li>
				            <%
				                }
				            %>
				            <li class="page-item <%= (currentPage == totalPages) ? "disabled" : "" %>">
				                <a class="page-link" href="?page=<%= currentPage + 1 %>" aria-label="Next">
				                    <span aria-hidden="true">&raquo;</span>
				                </a>
				            </li>
				        </ul>
				    </nav>
				</div>
            <a href="/ibom" class="btn btn-home">홈으로</a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	document.getElementById('search').addEventListener('keyup', function() {
	    var text = this.value;
	    
	    $.ajax({
	        url: "/ibom/search",
	        type: "POST",
	        data: JSON.stringify({ text: text }),
	        contentType: "application/json",
	        success: function(data) {
	            console.log("서버 응답:", data);
	            var tableBody = document.querySelector('tbody');
	            tableBody.innerHTML = '';
	            
	            // 데이터 처리 및 테이블 업데이트
	            data.forEach(function(member) {
	                var row = document.createElement('tr');
	                row.innerHTML = 
	                    '<td>' + member.id + '</td>' +
	                    '<td>' + member.name + '</td>' +
	                    '<td>' + member.birth + '</td>' +
	                    '<td>' + member.phone + '</td>';
	                tableBody.appendChild(row);
	            });
	        },
	        error: function(err) {
	            console.log("오류 발생", err);
	        }
	    });
	});
</script>


  
</body>
</html>
