<%@page import="com.example.demo.entity.Shoes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Shoes> s=(List<Shoes>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Sno</th><th>Sname</th><th>Category</th><th>Price</th><th>edit</th><th>delete</th></tr>
<%for(Shoes ss:s){ %>
<tr><td><%=ss.getId() %></td><td><%=ss.getName() %></td><td><%=ss.getCategory() %></td><td><%=ss.getPrice() %></td><td><a href="./edit.jsp">Edit</a></td><td><a href="./delete.jsp">delete</a></td></tr>
<%} %>
</table>
</body>
</html>