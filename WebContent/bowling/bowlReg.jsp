<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>bowlReg.jsp</h3>
<form action="bowlRegProc.do" method="post">
	<dl>
		<dt>제목</dt>
		<dt>
			<input type="text" name="btitle"/>
		</dt>
	</dl>
	<dl>
		<dt>작성자</dt>
		<dt>
			<input type="text" name="bwriter"/>
		</dt>
	</dl>
	<dl>
		<dt>내용</dt>
	</dl>
	<div>
		<textarea name="bcontent" cols="40" rows="20">aaa</textarea>
	</div>
	
	<input type="submit" value="저장" />
	<input type="button" value="취소" onclick="location.href='bowlNotice.do'"/>

</form>

</body>
</html>