<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World2!</h2>
<br/><br/>
<a href="https://sso.wsria.com:8443/cas/logout?service=https://client.wsria.com:9443/shiro_app/index" >注销1</a>
<a href="<c:url value="/logout" />" >注销2</a>

</body>
</html>
