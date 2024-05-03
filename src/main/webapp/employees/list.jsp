<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/3/2024
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-3 m-2"></div>
<h1>Danh sách nhân viên</h1>
<a href="/EmployeeServlet?action=ADD">Thêm mới nhân viên</a>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">No.</th>
        <th scope="col">Name</th>
        <th scope="col">Sex</th>
        <th scope="col">Birthday</th>
        <th scope="col">Address</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="em" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${em.name}</td>
            <td>${em.sex}</td>
            <td>${em.formatDate()}</td>
            <td>${em.address}</td>
            <td><a href="/EmployeeServlet?action=EDIT&id=${em.id}" class="btn btn-warning">Edit</a></td>
            <td><a href="/EmployeeServlet?action=DELETE&id=${em.id}" class="btn btn-danger" onclick="return confirm('Bạn co chan chan muon xoa khong?')">Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
