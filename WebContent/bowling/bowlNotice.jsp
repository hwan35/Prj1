<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h3>bowlNotice.jsp</h3>

Total ${cnt }건
<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>글쓴이</td>
		<td>날짜</td>
		<td>조회</td>
	</tr>
	
	<c:forEach items="${list }" var="b">
		<tr>
			<td>${b.bno }</td>
			<td><a href="bowlDetail.do?c=${b.bno }">${b.btitle }</a></td>
			<td>${b.bwriter }</td>
			<td>${b.bdate }</td>
			<td>${b.bcnt }</td>
		</tr>
	</c:forEach>
</table>

<form action="bowlNotice.do" method="get">
	<select name="f">
		<option ${param.f=="btitle"?"selected":"" } value="btitle">제목</option>
		<option ${param.f=="bcontent"?"selected":"" } value="bcontent">내용</option>
	</select>
	<input type="text" name="q" value="${query }"/>
	<input type="submit" value="검색"/>
</form>
<a href="bowlReg.do" class="btn">글쓰기</a>

</body>
</html>