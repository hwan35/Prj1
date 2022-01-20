<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/dstyle.css" />
</head>
<body>
<h1>자유게시판</h1>
<hr />
<table>
	<tr>
		<td colspan="3"><h2>${b.btitle }</h2></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><strong>${b.bwriter }</strong></td>
		<td>${b.bdate }</td>
		<td>조회 ${b.bcnt }회</td>
	</tr>
	<tr>
		<td colspan="3">${b.bcontent }</td>
	</tr>
</table>
<a href="bowlEdit.do?c=${b.bno }" class="btn">수정</a>
<a href="bowlDelProc.do?c=${b.bno }" class="btn">삭제</a>
<a href="bowlNotice.do" class="btn">목록</a>
</body>
</html>