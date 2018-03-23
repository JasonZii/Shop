<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

	<!-- MetisMenu CSS -->
	<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

	<!-- DataTables CSS -->
	<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
		  type="text/css">
	<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
		  type="text/css">
<title>出错了 -</title>

<body>
	<div id="main">
		<!----submenu------->
		<div class="pbox">
			<div class="error_cont">
				<div class="error_box">
					<img src="<%=basePath%>img/po.jpg" style="width: 400px;height: 400px;">
						<h2>HTTP错误 404 - 文件或目录未找到</h2>
						<p>
							<span id="totalSecond"></span>
							<a href="<%=basePath%>login/test">重新登陆</a>
						</p>
						<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!----mainOver------>
			<div class="clear1"></div>
		</div>
	</div>
</body>
</html>