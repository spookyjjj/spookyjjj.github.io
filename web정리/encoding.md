### 파라미터 인코딩방법
- post방식
  - form.jsp가 만드는 응답 결과 화면를 어떤 인코딩으로 하였느냐 -> charset 부분
  ```
  <%@ page contentType="text/html; charset=utf-8" %>  
  ...  
  이름: <input type="text" ~ >  
  ```
  - 그럼 제출로 폼을 전송했을 때도, 위의 charset에 맞게 파라미터를 인코딩해서 요청을 전송
  - --------
  - 요청을 전달받은 페이지에서 getParameter할 때, 디코딩 -> .setCharacterEncoding()
  ```  
  <%  
	request.setCharacterEncoding("utf-8");  
  %>  
  ...  
  <%= request.getParameter("name") %>  
  ```  
  - .setCharacterEncoding()는 반드시 getParameter메소드 호출전에 지정해줘야하며
  - 지정을 안했다면 기본값인 iso-8859-1로 디코딩ㅎㅎ
- get방식
  - get방식으로 파라미터를 전송하는데는 세가지 방법이 있다
  - [1] form.jsp에서 method는 get으로 설정한 경우
    - post방식과 마찬가지로 form화면 생성시에 사용한 인코딩값으로 파라미터를 전송
  - [2] \<a href=""\>의 주소값에 쿼리문자열 추가
    - 역시 마찬가지로 해당 태그가 존재하는 페이지에 사용한 인코딩 값으로 파라미터를 전송
  - [3] 웹브라우저 주소창에 직접 쿼리문자열을 넣어 url입력
    - 이 경우에는 페이지 거치지 않고 직접 경로를 쳐넣은거라 웹브라우저마다 인코딩 값이 다름
	- 익스플로러는 ms949로 인코딩하고, 크롬은 utf-8로 인코딩해서 전송한다
  - ---- 
  - ★get에서는 .setCharacterEncoding()을 사용하지 못한다!!
  - setCharacterEncoding메소드는 http프로토콜의 데이터 영역을 인코딩할 때 사용할 캐릭터셋 지정이라서
  - post에서는 파라미터가 데이터 영역을 통해 전달되므로 이 메소드의 영향을 받지만
  - get방식에서는 파라미터가 데이터 영역이 아닌 요청라인에 uri와함께 쿼리문자열로 파라미터를 전달하기때문에 영향X
  - 그렇다면 해결방안?
    - server.xml파일에서 connector의 useBodyEncodingForURI속성을 true로 변경해줘야함
	- 또는 useBodyEncodingForURI가 아닌 URIEncoding속성을 사용하던가..
	- 자세한건 검색ㄱㄱ
