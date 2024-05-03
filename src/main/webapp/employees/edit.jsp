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
</head>
<body>
<h1>Sửa nhân viên</h1>
<form action="/EmployeeServlet" method="post">
    <table border="10" cellpadding="10" cellspacing="10">
        <tr>
            <th>Id</th>
            <td><input type="text" name="id" readonly value="${employee.id}"></td>
        </tr>
        <tr>
            <th>Tên</th>
            <td><input type="text" name="name"  value="${employee.name}"></td>
        </tr>
        <tr>
            <th>Giới tính</th>
            <td><input type="radio" name="sex" ${employee.sex?"checked":""} value="true"><span>Nam</span>
                <input type="radio" name="sex" ${!employee.sex?"checked":""} value="false"><span>Nữ</span></td>
        </tr>
        <tr>
            <th>Ngày sinh</th>
            <td><input type="date" name="birthDay" value="${employee.formatDate()}"></td>
        </tr>
        <tr>
            <th>Địa chỉ</th>
            <td><input type="text" name="address"  value="${employee.address}"></td>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="UPDATE" name="action"></th>
        </tr>
    </table>
</form>
</body>
</html>
