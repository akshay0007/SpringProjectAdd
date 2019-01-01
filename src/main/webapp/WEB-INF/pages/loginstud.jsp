<%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 30/12/18
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/addData">
    <div>
        <input type="text" name="stuname"/>
        <input type="text" name="password"/>
        <input type="text" name="date"/>
        <select name="skills" multiple>
            <option value="java core">java core</option>
            <option value="java core">java core</option>
            <option value="java core">java core</option>
        </select>
    </div>

</form>
</body>
</html>
