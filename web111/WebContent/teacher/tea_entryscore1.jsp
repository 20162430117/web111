<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.TeacherDao"%>
<%@page import="bean.Teacher"%>
<%@page import="dao.CourseDao"%>
<%@page import="bean.Course"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<base href="<%=basePath%>">
</head>
<body>
<table width="1000" height="200" align="center" border="1" cellpadding="3">
  <tr>
    <td colspan="5"> 您所开设的课程如下：</td>
  </tr>
  <tr>
    <td><div align="center">课程编号</div></td>
    <td><div align="center">课程名称</div></td>
    <td><div align="center">学分</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  	 <c:forEach items="${courses}" var="course">
  		<tr bgcolor="#F0FFF0">
   			 <td><div align="center">${course.courseno }</div></td>
    		 <td><div align="center">${course.coursename }</div></td>
   			 <td><div align="center">${course.credit }</div></td>
    		 <td><div align="center"><a href="TeaScore2Servlet?courseno=${course.courseno }">录入分数</div></td>
  	   </tr>
  	 </c:forEach>	
   </table>
</body>
</html>