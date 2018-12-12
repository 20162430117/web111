<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>

  <body >
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
  
  <script type="text/javascript">
  		function getCode(){
  			document.getElementById("imgValidate").src ="code/code.jsp?"+Math.random();
  			//document.form1.codeimg.src="code/code.jsp";
  		}
  		
  </script>
  
  <%
String applicantEmail = "";
String applicantPwd = "";
// 从客户端读取Cookie
Cookie[] cookies = request.getCookies();  
if (cookies != null) {  
  for (Cookie cookie : cookies) {  
    if ("COOKIE_APPLICANTEMAIL".equals(cookie.getName())) {  
    	// 解密获取存储在Cookie中的求职者Email
      applicantEmail = util.CookieEncryptTool.decodeBase64(cookie.getValue());   
    }  
    if ("COOKIE_APPLICANTPWD".equals(cookie.getName())) {  
    	// 解密获取存储在Cookie中的求职者登录密码
      applicantPwd = util.CookieEncryptTool.decodeBase64(cookie.getValue());  
    }  
  }
}
%>
<div  align="center" >  
	<h1>欢迎来到学生管理系统</h1>
	<br><br><br><br></div>
    <table  width="100%" height="100%">
 
  <tr>
    <td width="36%" height="40%">
    	<form action="loginservlet" method="post"  name="form1" id="form1" onsubmit="return check()">
		<table width="280" align="center">
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">身份:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>学生</option>
		        <option value="teacher">教师</option>
		      </select></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">账号:</font></div></td>
		    <td><input type="text" name="account" value="<%=applicantEmail%>"></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">密码:</font></div></td>
		    <td><input type="password" name="password" value="<%=applicantPwd%>" size=21></td>
		  </tr>
		  <tr><td><div align="right"><font size="-1" color="#556B2F">验证码:</font></div></td>
		  	  <td><input name="code" size=12> <a href="#" onclick="javascript:getCode();return false;"><font size="-1">看不清，换一张</font></a></td>
		  </tr>
		  <tr><td colspan="2"><div align="center">
    	  	  <img   id="imgValidate" src="code/code.jsp" onclick="getCode()" ></div></td>
    	  </tr>
		  <tr>
		    <td colspan="2"><div align="center">
		        <input type="submit" name="submit" value="登录">
		        <input type="reset" name="reset" value="重置">  
		        <input
						checked="checked" name="rememberMe" id="rememberMe"
						class="tn-checkbox" type="checkbox" value="true"> <label
						for="RememberPassword" style="color: gray"> 记住密码</label>    
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
