<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="dao.Studao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<script type="text/javascript">
  function check(){
    var mymessage=confirm("确定要删除吗？");  
    if(mymessage==true){  
       return true;
    }  
    else if(mymessage==false){  
       return false;
    }   
    
  }
  </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学生信息列表</title>

</head>
<body background="11.jpg">
<div align="right">欢迎你，${teacher.teano==null?"游客":teacher.teano}&nbsp;&nbsp;&nbsp;</a></div>
<h2>学生列表</h2>
<%-- <p><a href="addStu.jsp"><input type="button" value="添加学生"></a></p>--%>

<table border="1" bordercolor="000000" width="1000px" cellpadding="5" cellspacing="0">

<tr bgcolor="#F0FFF0">
	    <td><div align="center">学号</div></td>
	    <td><div align="center">性别</div></td>
	    <td><div align="center">姓名</div></td>
	    <td><div align="center">院系</div></td>
		<td></td>
  	</tr>	
  	<c:forEach items="${stulist}" var="stulist">
		<tr bgcolor="#F0FFF0">
		<td><div align="center">${stulist.stuno }</div></td>
		<td><div align="center">${stulist.stusex }</div></td>
		<td><div align="center">${stulist.stuname}</div></td>
		<td><div align="center">${stulist.stugrade}</div></td>
		<td>
        <a href="modifystu.jsp?id=${stulist.stuno}">修改</a>
        <a href="delStudent?id=${stulist.stuno}" 
        onclick="return check()">
                     删除</a></td>
		</tr>
	</c:forEach>



</body>
</html>