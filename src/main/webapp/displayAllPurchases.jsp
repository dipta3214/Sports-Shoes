<%@page import="com.example.demo.entity.Purchase"%>
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
<%List<Purchase> s=(List<Purchase>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Sno</th><th>PurchaseDate</th><th>Sname</th><th>Category</th><th>Price</th><th>edit</th><th>delete</th></tr>
<%for(Purchase ss:s){ %>
<tr><td><%=ss.getId() %></td><td><%=ss.getPurchaseDate() %></td><td><%=ss.getShoeName() %></td><td><%=ss.getCategory() %></td><td><%=ss.getTotalPrice() %></td></tr>
<%} %>
</table>
</body>
</html>