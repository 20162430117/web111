<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>

  <body >
  <script type="text/javascript">
  function check() {
		for (var i = 0; i < document.form1.elements.length - 1; i++) {
			if (document.form1.elements[i].value == "") {
				alert("��ǰ�������п���");
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
// �ӿͻ��˶�ȡCookie
Cookie[] cookies = request.getCookies();  
if (cookies != null) {  
  for (Cookie cookie : cookies) {  
    if ("COOKIE_APPLICANTEMAIL".equals(cookie.getName())) {  
    	// ���ܻ�ȡ�洢��Cookie�е���ְ��Email
      applicantEmail = util.CookieEncryptTool.decodeBase64(cookie.getValue());   
    }  
    if ("COOKIE_APPLICANTPWD".equals(cookie.getName())) {  
    	// ���ܻ�ȡ�洢��Cookie�е���ְ�ߵ�¼����
      applicantPwd = util.CookieEncryptTool.decodeBase64(cookie.getValue());  
    }  
  }
}
%>
<div  align="center" >  
	<h1>��ӭ����ѧ������ϵͳ</h1>
	<br><br><br><br></div>
    <table  width="100%" height="100%">
 
  <tr>
    <td width="36%" height="40%">
    	<form action="loinservlet" method="post"  name="form1" id="form1" onsubmit="return check()">
		<table width="280" align="center">
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">���:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>ѧ��</option>
		        <option value="teacher">��ʦ</option>
		        <option value="guanli">����Ա</option>
		      </select></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">�˺�:</font></div></td>
		    <td><input type="text" name="account" value="<%=applicantEmail%>"></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">����:</font></div></td>
		    <td><input type="password" name="password" value="<%=applicantPwd%>" size=21></td>
		  </tr>
		  <tr><td><div align="right"><font size="-1" color="#556B2F">��֤��:</font></div></td>
		  	  <td><input name="code" size=12> <a href="#" onclick="javascript:getCode();return false;"><font size="-1">�����壬��һ��</font></a></td>
		  </tr>
		  <tr><td colspan="2"><div align="center">
    	  	  <img   id="imgValidate" src="code/code.jsp" onclick="getCode()" ></div></td>
    	  </tr>
		  <tr>
		    <td colspan="2"><div align="center">
		        <input type="submit" name="submit" value="��¼">
		        <input type="reset" name="reset" value="����">  
		        <input
						checked="checked" name="rememberMe" id="rememberMe"
						class="tn-checkbox" type="checkbox" value="true"> <label
						for="RememberPassword" style="color: gray"> ��ס����</label>    
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
