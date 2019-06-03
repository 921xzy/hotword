<%@page import="java.util.ArrayList"%>
<%@page import="hotword.bean.HotWord"%>
<%@page import="java.util.List"%>
<%@page import="hotword.dao.HotWordDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/*7个分类：
		企业、市场、趋势、热点、视点、财经、技术
	*/
	String[] typeName = {"企业","市场","趋势","热点","视点","财经","技术"};
	//System.out.println("-----"+typeName.length);
	HotWordDaoImpl wordDao = new HotWordDaoImpl();
	List<HotWord> hotwords = new ArrayList();
  
   for(int i = 0;i < 7;i++){
   %>
	   	<h3><%=typeName[i] %></h3>
	<%
		hotwords = wordDao.load_type(typeName[i]);
	    for(HotWord word : hotwords)
	   {
   	%>
      		<p>&nbsp;&nbsp;&nbsp;&nbsp;<%=word.getName() %></p>
	<%
	   }
	}
	%>
</body>
</html>