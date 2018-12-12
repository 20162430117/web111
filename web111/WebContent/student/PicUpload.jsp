<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var headShot = document.getElementById("headSh");
		if (headShot.value == "") {
			alert("请选择要上传的头像！");
			headShot.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<!-- 简历照片上传页面 开始 -->
	<div class="resume_con">
		
		<!--主体部分-->
		<div >
			<!--左边-->
			<div >
				<div >
					<div style="float: left">简历照片</div>
				</div>
				<div >
					<!--------------------- 简历照片修改------------------------->
					<form action="PicUploadServlet" method="post"
						enctype="multipart/form-data" onsubmit="return validate();">
						<div  style="margin-left: 150px;">
							<div >
								<div align="center">
									<img src="images/anonymous.png" width="150" height="150">
									<p>&nbsp;</p>
									<input name="headSh" id="headSh" type="file" value="上传照片">
								</div>
							</div>
							
							<div align="center">
								<input name="submit" type="submit" class="save1" value="保存"> 
								<input name="reset" type="reset" class="cancel2" value="取消">
							</div>
						</div>
					</form>
					<!--------------------- 简历照片修改 结束---------------------->
				</div>

</body>
</html>