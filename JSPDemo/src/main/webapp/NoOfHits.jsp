<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
	int count = 0 ; 
	
	int getCount(){
		//++count ; 
		return ++count;
	}
%>
	
 <%  

 		
 	//out.println("no of hits/visits to this page is  :: "+getCount());
 	//int a=10,b=5;
 	//out.println("a - b ="+a-b);
 %>
 <%= "no of hits/visits to this page is  :: "+getCount()%>
 
 
 
</body>
</html>