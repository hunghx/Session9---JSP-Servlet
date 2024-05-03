<%@ page import="ra.web.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/3/2024
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
Cú phap   java
<%=%> - xử lí biểu thức
<%!%> - Khai báo
<%%> - code logic
--%>

<%!
    int a = 100;
    String name = "Quỳnh anh";
%>
<%
    if (a>100){
        System.out.println("chết");
    }else {
        System.out.println("Sông");
    }
%>



<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
   Name : ${student.name} - ID : ${student.id}
</p>
</body>
</html>
