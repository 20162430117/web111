<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 <center><font size="+1" color="red">${msg3}</font></center>
  	 <c:if test="${msg3==null}">
  	 <form action="StuExportScoreServlet" method="post">
  		<table width="1000" height="200" align="center" border="1" cellpadding="3">
	 	 <tr >
	   		 <td colspan="5"><font color="#556B2F"> 您的课程成绩如下：</font></td>
		 </tr>
	  <tr >
	    <td><div align="center">课程编号</div></td>
	    <td><div align="center">课程名称</div></td>
	    <td><div align="center">学生学号</div></td>
	    <td><div align="center">学生姓名</div></td>
	    <td><div align="center">分数</div></td>
	  </tr>
  		<c:forEach items="${score}" var="score">
  			<tr >
		    <td><div align="center">${score.courseno }</div></td>
			<td><div align="center">${score.coursename }</div></td>
			    <td><div align="center">${score.stuno }</div></td>
			    <td><div align="center">${student.stuname }</div></td>
			<c:choose>
			    <c:when test="${score.score!=0}">
			    <td><div align="center">${score.score}</div></td> </c:when>   
  				<c:otherwise>
  				<td><div align="center">未登分</div></td> </c:otherwise>
  			</c:choose>
  			</tr>
  		</c:forEach>
  		<%-- <tr>
	       <td colspan="6"><div align="center"><input type="submit" value="导出到PDF文件"></div></td>
	    </tr>--%>
	  </table>
	  </form>
	</c:if>
</body>