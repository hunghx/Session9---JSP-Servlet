<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--điều hướng theo đuờng dẫn--%>
<%response.sendRedirect("/EmployeeServlet?action=LIST");%>
<%--
gõ trên đường /list
--%>
<%!
 int[] arr = {1,2,3,4,5};
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="//EmployeeServlet?action=LIST">Danh sách nhân viên</a>

<a href="<%=request.getContextPath()%>/hello-servlet">Hello Servlet</a> <br>
<a href="hello-servlet">Hello Servlet</a> <br>
<a href="/HomeServlet?action=List">List</a> <br>
<a href="/HomeServlet">Hello Servlet</a>
<br>
<form action="/HomeServlet" method="post">
    <input type="text" placeholder="nhập bất cư điều gì" name="keyword">
    <input type="submit" value="send">
</form>

<c:set var="cat" value="Tom" scope="page"/>
<p><c:out value="${cat}"/></p>

<c:if test="${cat.length()>10}">
    <p>Lớn hơn 10 kí tự</p>
</c:if>

<c:choose>
    <c:when test="${cat.length()<10}">
        <p>..... < 10</p>
    </c:when>
    <c:when test="${cat.length()<20}">
        <p>..... < 20</p>
    </c:when>
    <c:otherwise>
        <p>khác</p>
    </c:otherwise>
</c:choose>
<c:forEach items="<%=arr%>" var="num" varStatus="loop">
    <li id="${loop.count}"> ${num}</li>
</c:forEach>

</body>
</html>