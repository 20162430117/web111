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
  <tr>
    <td >学号</td>        
    <td >密码</td>
    <td >姓名</td>
    <td >性别</td>
    <!--<td >年级</td> --> 
   <td >信息</td>

  </tr>
<tr>
	<td>${student1.stuno }</td>
	<td>${student1.password }</td>
	<td>${student1.stuname }</td>
	<td>${student1.stusex }</td>
	<td>${student1.stugrade }</td>
	

</tr>
</body>
</html>