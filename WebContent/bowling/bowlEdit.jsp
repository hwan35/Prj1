<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/estyle.css" />
</head>
<body>
<h1>글수정</h1>
<form action="bowlEditProc.do" method="post">
<table>
	<tr>
		<td>${b.bdate }</td>
		<td>조회 ${b.bcnt }회</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">
		<input type="text" name="btitle" value="${b.btitle }"/>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3">
		<input type="text" name="bwriter" value="${b.bwriter }"/>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
		<textarea cols="40" rows="20" >${b.bcontent }</textarea>
		</td>
	</tr>
</table>
<input type="hidden" name="c" value="${b.bno }"/>
<input type="submit" value="저장" />
<a href="bowlDetail.do?c=${b.bno }" class="btn">취소</a>
<a href="bowlNotice.do" class="btn">목록</a>
</form>
</body>
</html>