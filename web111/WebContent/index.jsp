<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
  <body >
  <script type="text/javascript">
  		function getCode(){
  			document.form1.codeimg.src="code/code.jsp";
  		}
  </script>
<div  align="center" >  
	<h1>��ӭ����ѧ������ϵͳ</h1>
	<br><br><br><br></div>
    <table  width="100%" height="100%">
 
  <tr>
    <td width="36%" height="40%">
    	<form method="post" action="loginservlet" name="form1">
		<table width="280" align="center">
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">���:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>ѧ��</option>
		        <option value="teacher">��ʦ</option>
		      </select></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">�˺�:</font></div></td>
		    <td><input type="text" name="account"></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">����:</font></div></td>
		    <td><input type="password" name="password" size=21></td>
		  </tr>
		  <tr><td><div align="right"><font size="-1" color="#556B2F">��֤��:</font></div></td>
		  	  <td><input name="code" size=12> <a href="#" onclick="getCode()"><font size="-1">�����壬��һ��</font></a></td>
		  </tr>
		  <tr><td colspan="2"><div align="center">
    	  	  <img name="codeimg" src="code/code.jsp"></div></td>
    	  </tr>
		  <tr>
		    <td colspan="2"><div align="center">
		        <input type="submit" name="submit" value="��¼">
		        <input type="reset" name="reset" value="����">      
		          </div></td>
		  </tr>
		  <tr>
		    <td colspan="2"><div align="center"><font size="-1" color="red"><b>${msg1}</b></font></div></td>
		  </tr>
		</table>
    </form> 
</table>
  </body>
</html>
