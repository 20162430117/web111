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
<table witdh="100%" height="100%" border="1">
			
			<tr>
				<td height=100px width="10%" align="center"><a href="Sstudetail.jsp"  target="iframe1" style=text-decoration:none>>详细信息</a></td>
				<td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" ></iframe></td>
			</tr>
			<tr height=100px><td width="10%" align="center"><a href="StuselectCourseServlet" style=text-decoration:none>选课</a></td></tr>
			<tr height=100px><td width="10%" align="center"><a href="StuQueryCourseServlet" style=text-decoration:none>选课结果</a></td></tr>
			
			<tr height=100px><td width="10%" align="center"><a href="logout.jsp" style=text-decoration:none>退 出</a></td></tr>
			
			<tr heigth=200px><td colspan="2">
			<pre style="display:inline"><font color="#556B2F">                                                                                                         </font></pre>
			</td></tr>
		</table>
</body>
</html>