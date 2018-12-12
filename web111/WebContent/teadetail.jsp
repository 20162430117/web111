<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<table border="1" bordercolor="000000" width="1000px" cellpadding="5" cellspacing="0">

<tr bgcolor="#F0FFF0">
	    <td><div align="center">帐号</div></td>
	    <td><div align="center">密码</div></td>
	    <td><div align="center">姓名</div></td>
	    <td><div align="center">性别</div></td>
		<td><div align="center">职位</div></td>
  	</tr>	

		<tr bgcolor="#F0FFF0">
		<td><div align="center">${teacher.teano}</div></td>
		<td><div align="center">${teacher.password }</div></td>
		<td><div align="center">${teacher.teaname}</div></td>
		<td><div align="center">${teacher.teasex}</div></td>
		<td><div align="center">${teacher.title}</div></td>
		</tr>
</body>
</html>