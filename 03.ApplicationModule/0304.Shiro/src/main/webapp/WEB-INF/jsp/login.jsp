<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<form action="<c:url value="/login" />" method="post">
    <input type="text" id="username" name="username"  value="${username}" placeholder="请输入账户名"/>
    <input type="password" id="password" name="password" placeholder="请输入密码"/>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
