<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<shiro:principal property="nickName"></shiro:principal><br>
=======================
<shiro:user></shiro:user><br>
this is user index jsp
<shiro:hasPermission name="user:add">
	user:add
</shiro:hasPermission>
<shiro:hasPermission name="user:delete">
	user:delete
</shiro:hasPermission>
<shiro:hasRole name="role1">
	role1
</shiro:hasRole>
<shiro:hasRole name="role2">
	role2
</shiro:hasRole>
<a href="${pageContext.request.contextPath }/auth/logout">退出</a>
</body>
</html>