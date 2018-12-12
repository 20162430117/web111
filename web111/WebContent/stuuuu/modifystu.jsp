<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.Student"%>
<%@page import="dao.Studao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<script type="text/javascript">
  function check() {
		for (var i = 0; i < document.form1.elements.length - 1; i++) {
			if (document.form1.elements[i].value == "") {
				alert("当前表单不能有空项");
				document.form1.elements[i].focus();
				return false;
			}
		}
		return true;

		}
  
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>

<body background="11.jpg" >
<h2>修改学生信息</h2>
<form action="modifyStuServlet" method="post" name="form1" onsubmit="return check()">
  <table id="stuDetailList">
<%
	//int id=Integer.parseInt(request.getParameter("id"));
    String stuno=request.getParameter("id");
    Studao studao=new Studao();
    Student stu =new Student();
 // stu.setId(id);
   stu.setStuno(stuno);
   stu=studao.getStudentInfo(stu);
   session.setAttribute("stu", stu);
%>
		<%-- <td>学号：</td>
        <td><div align="center">${stu.stuno }</div></td>
        <td>性别：</td>
		<td><div align="center">${stu.stusex }</div></td>.
		<td>姓名：</td>
		<td><div align="center">${stu.stuname}</div></td>
		<td>信息：</td>
		<td><div align="center">${stu.stugrade}</div></td>
		--%>
  <%-- <tr>
     <td>学号：</td>
    <td><input type="text" name="stuno" value="${stu.stuno }"></td>
  </tr>--%>
    <tr>
    <td>性别：</td>
    <td><input type="text" name="stusex" value="${stu.stusex }"></input></td>
  </tr>
    <tr>
    <td>姓名：</td>
    <td><input type="text" name="stuname" value="${stu.stuname}"></td>
  </tr>
   
    <td>信息：</td>
    
    <td><textarea name="stugrade" cols="40" rows="6" >${stu.stugrade}</textarea></td>
   </tr>
       <tr>
       <td><input type="hidden" name="stuId" value="${stu.stuno }"></td>
    <td colspan="2" style="text-align: center"><input type="submit" value="提交信息"></td>
   </tr>
  </table>
</body>
</html>