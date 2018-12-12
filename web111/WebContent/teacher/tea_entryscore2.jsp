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
</head>
<base href="<%=basePath%>">
<body>
	<c:choose>
		<c:when test="${msg5!=null}">
			<center><font size="+1" color="red">${msg5}</font></center>
		</c:when>
		<c:when test="${msg6!=null}">
			<center><font size="+1" color="red">${msg6}</font></center>
		</c:when>
		<c:otherwise>
				<form action="TeaScore2Servlet" method="post">
  			<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr >
			    <td colspan="5"> 欢迎前来登分：</td>
			  </tr>
			  <tr >
			    <td><div align="center">课程编号</div></td>
			    <td><div align="center">课程名称</div></td>
			    <td><div align="center">学生学号</div></td>
			    <td><div align="center">学生姓名</div></td>
			    <td><div align="center">分数</div></td>
			  </tr>
  		 <c:forEach items="${scores}" var="score">
	  		<tr >
			    <td><div align="center">${score.courseno }<input type="hidden" name="courseno" value="${score.courseno }"></div></td>
			    <td><div align="center">${score.coursename }</div></td>
			    <td><div align="center">${score.stuno }<input type="hidden" name="stuno" value="${score.stuno }"></div></td>
			    <td><div align="center">${score.stuname }</div></td>
			    <td>
			    	<c:choose>
				 		<c:when test="${score.score==0 }">
			    	    <div align="center"><input type="text" name="score" value=""></div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${score.state==null||score.state=='暂存'}">
	  					      <div align="center"><input type="text" name="score" value="${score.score }"></div>
	  				          </c:when>
	  				          <c:when test="${score.state=='提交'}">
	  					      <div align="center">${score.score }</div>
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			</td> </tr>
	  		</c:forEach>
	  		<tr >
		       <td colspan="6"><div align="center"><input type="submit" name="submit" value="暂存">
		       <input type="submit" name="submit" value="提交"></div></td>
			</tr>
  	      </table>
	   </form>
		</c:otherwise>
	</c:choose>

</body>
</html>