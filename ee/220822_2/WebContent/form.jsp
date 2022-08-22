<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form>
		<input type="text" name="id" id="textid"/>
		<button id="btnchk">아이디중복확인</button>
		<!-- 비동기요청어쩌고? ajax -->
		<!--  form안의 버튼은 기본적으로 submit이 발생 -->
		<input type="submit" />
	</form>
</body>
<script>
	let elem = document.getElementById("btnchk");
	elem.addEventListener("click", function (e) {
		e.preventDefault();
		e.stopPropagation();
		let textid = document.getElementById("textid").value;
		
		if (!textid) {
			return;
		}
		
		fetch("http://localhost:8080/api/idcheck?id=" + textid)
			.then((resp) => resp.text())
			.then((json) => {
				let result = JSON.parse(json);
				if (result.duplicate) {
					//duplicate에서 5글자 이상이면 중복이었음
					alert("중복");
				} else {
					alert("사용 가능");
				}
			})
			.catch((e) => console.log(e));
	});
</script>
</html>