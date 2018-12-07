<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加学生</title>
<script type="text/javascript">
	function check(){
		for (var i=0;i<doucment.form1.elelmemnts.length-1;i++){
			if(doucment.form1.elements[i].value ==""){
				alert("当前表单不能有空项");
				doucment.form1.elelmemnt[i].focus();
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body background="11.jpg">
<h2>添加学生信息</h2>
<form action="addStuServlet" name="form1" method="post" onsubmit="return check()">
  <table>
  <tr>
     <td>学号：</td>
    <td><input type="text" name="id"></td>
  </tr>
  <tr>
     <td>密码：</td>
    <td><input type="text" name="stupwd"></td>
  </tr>
    <tr>
    <td>性别：</td>
    <td><input type="radio" name="sex" value="男" checked="checked">男<input type="radio" name="sex" value="女">女</td>
  </tr>
    <tr>
    <td>姓名：</td>
    <td><input type="text" name="stuname"></td>
  </tr>
  
  </tr>
    <tr>
    <td>详细信息：</td>
    <td><textarea name="showProfile" cols="40" rows="6" ></textarea></td>
   </tr>
       <tr>
    <td colspan="2" style="text-align: center"><input type="submit" value="提交信息"></td>
   </tr>
   </table>
   </form>
</body>
</html>