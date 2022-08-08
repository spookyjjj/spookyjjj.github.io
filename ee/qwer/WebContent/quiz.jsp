<%-- jsp 페이지의 설정이 들어있는 page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퀴즈 페이지</title>
</head>
<body>
	
	<!-- action 속성 값을 설정하여 submit입력값을 처리할 수 있는 페이지로 요청(이동) -->
	<form action="/qwer/answer.jsp" method = "post" >
	<p>다음 문제의 답을 입력하세요.</p>
		<img src = "/qwer/찢어진 달력.png" /><br />
		<p>달력이 찢어졌는데 마침 집 안의 모든 전자제품이 고장이 났어요!<br />
		그런데 이번 달의 세번째 일요일이 며칠인지 너무너무 궁금해요! 며칠일까요?</p>
		<label>정답 입력 : <input type = "number" name = "answer1">일</label><br /><br />
		<!-- 사용자 입력을 받을 수 있는 form을 작성하세요. -->
		<img src = "/qwer/농도.jpg" /><br />
		<p>집에 대체 왜 있었는지 모를 소금물과 아무것도 안섞인 물을 섞어봤어요!<br />
		어떻게 안건진 모르겠지만 다 섞고보니 8%의 소금이 섞여있다는걸 알게됐어요.<br />
		대체 섞었던 소금물의 농도가 몇퍼였던걸까요?</p>
		<label>정답 입력 : <input type = "number" name = "answer2">%</label><br /><br />
		<img src = "/qwer/왜따로갈까.png" /><br />
		<p>동생은 내일 발표하는 숙제가 적힌 교과서를 안가져온걸 깨닫고 오후 7시에 학교로 출발했어요!<br />
		동생은 정확하게 시속 4km의 속도로 학교로 갔어요.<br />
		형은 동생이 출발한지 5분만에 그 교과서를 자기가 가지고있다는 걸 알아버렸어요...<br />
		하지만 동생이 하필이면 휴대폰을 가지고가지 않았어요.<br />
		형은 동생을 따라잡기 위해 정확하게 시속 6km의 속도로 학교로 달려갔어요.<br />
		동생과 형은 0.01mm의 오차도 없이 정확히 학교의 정문에서 마주쳤습니다.<br />
		이때 집에서 학교까지의 거리와 두 사람이 도착한 시간을 구해보세요!</p>
		<label>정답 입력 : <input type = "number" name = "answer3">km</label>
		<label><input type = "number" name = "answer4">시 
		<input type = "number" name = "answer5">분</label>
		<input type="submit" value="답안 제출" />
	</form>
</body>
</html>