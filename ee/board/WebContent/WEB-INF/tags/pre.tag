<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
	//value = value.replace("\n", "<br>"); 
	//\n변환이 위에 있으면 <br>변환 뒤, 꺽쇄변환을 만나게 되서 &ltbr&lt로바뀜
	//해석하면 <br>이 되어버린다는거~~ㅗㅗ
	value = value.replace("<", "&lt;"); 
	value = value.replace("\n", "<br>");
	value = value.replace("&", "&amp;");
	value = value.replace(" ", "&nbsp;");
%>
<%= value %>