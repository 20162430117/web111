<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="bean.Student"%>
<%@page import="dao.CourseDao"%>
<%@page import="bean.Course"%>
<%@page import="dao.TeacherDao"%>
<%@page import="bean.Teacher"%>
<%@page import="dao.ScoreDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body >
	<center><font size="+1" color="red">${msg2}</font></center>
	<c:if test="${msg2==null}">
	<form method="post" action="/web111/StuselectCourseServlet">
	<table width="1000" height="200" align="center" border="1" cellpadding="3">
	  <tr>
	  	<td colspan="6" ><font>您可以选择的课程如下： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">(注:必须选满20个学分,且不能多选)</td>
	  </tr>
	  <tr >
	    <td><div align="center">课程编号</div></td>
	    <td><div align="center">课程名称</div></td>
	    <td><div align="center">学分</div></td>
	    <td><div align="center">职工号</div></td>
	    <td><div align="center">授课老师</div></td>
	    <td><div align="center">选课</div></td>
	   </tr>
	   <c:forEach items="${allcourse}" var="course">
			<tr>
			<td><div align="center">${course.courseno }</div></td>
			<td><div align="center">${course.coursename }</div></td>
			<td><div align="center">${course.credit }</div></td>
			<td><div align="center">${course.teano }</div></td>
			<td><div align="center">${course.teaname }</div></td>
			<td><div align="center"><input  type="checkbox" name="${course.coursename }" value="${course.courseno }">
		</div></td>
			</tr>
	   </c:forEach>
	    <tr >
	       <td colspan="6"><div align="center">
	       <input type="submit" value="提交结果"></div></td>
	    </tr>
	</table>
	</form>
	</c:if>
</body>
</html>