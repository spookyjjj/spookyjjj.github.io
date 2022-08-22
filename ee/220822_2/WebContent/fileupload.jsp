<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일선택</title>
</head>
<body>
	<form action="/fileupload" method="post" enctype="multipart/form-data">
	<!-- 파일을 보내느거면 타입을 multipart/form-data이걸로 -->
	<!-- 언니야 수업 빨리 이해해서 나한테 가르쳐줘 알겟어ㅏ????? -->
	<!-- 나는 지금 무슨 말인지 1도 몰르겟어 -->
	<!-- 언니야만 믿고 있을게???  -->
	<!-- 집에 가고싶다 ,.,,,,,언니야 어디갓노 -->
	<!-- 언니야...!!!!!!!!!언니야 어디갔는데!!!!!!!!!!!!!! -->
	<!--집에가고싶다....언니....제발 집에보내도 -->
		<input type="file" name="upload" />
		<input type="submit" />
	</form>
</body>
</html>