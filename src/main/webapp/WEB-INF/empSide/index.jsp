<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>员工中心</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	</head>
	<body style="background-color:#f2f9fd;">
		<div class="header bg-main">
			<div class="logo margin-big-left fadein-top">
				<h1><img src="${pageContext.request.contextPath}/fileupload/${sessionScope.emp.empPhoto}" class="radius-circle rotate-hover" height="50" alt="" />员工办公中心</h1>
			</div>
			<div class="head-l">
				&nbsp;&nbsp;<a class="button button-little bg-red" href="${pageContext.request.contextPath}/index.jsp"><span class="icon-power-off"></span> 退出登录</a>
			</div>
			<div class="logo margin-big-right fadein-top" style="margin-left: 650px;">
				<h4>欢迎，<span style="font-family: 幼圆;color: #0000FF;font-size: 20px;font-weight: bold;">${sessionScope.emp.empName}</span></h4>
			</div>
		</div>
		<div class="leftnav">
			<div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
			<h2><span class="icon-code"></span>公司公告</h2>
			<ul style="display:block">
				<li><a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a" target="right"><span class="icon-magic"></span>公告</a></li>
			</ul>
			<h2><span class="icon-code"></span>请假</h2>
			<ul style="display:block">
				<li><a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a" target="right"><span class="icon-magic"></span>请假记录</a></li>
			</ul>
			<h2><span class="icon-code"></span>基本信息</h2>
			<ul style="display:block">
				<li><a href="${pageContext.request.contextPath}/empSide/toPass.a" target="right"><span class="icon-magic"></span>修改密码</a></li>
				<li><a href="${pageContext.request.contextPath}/empSide/toPersonal.a" target="right"><span class="icon-magic"></span>信息完善</a></li>
			</ul>
		</div>
		<script type="text/javascript">
			$(function() {
				$(".leftnav h2").click(function() {
					$(this).next().slideToggle(200);
					$(this).toggleClass("on");
				})
				$(".leftnav ul li a").click(function() {
					$("#a_leader_txt").text($(this).text());
					$(".leftnav ul li a").removeClass("on");
					$(this).addClass("on");
				})
			});
		</script>
		<ul class="bread">
			<li><a target="right" class="icon-home"> 首页</a></li>
		</ul>
		<div class="admin">
			<c:if test="${checkAtten.workTime==0}">
				<iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/empSide/checkAtten.a" name="right" width="100%" height="100%"></iframe>
			</c:if>
			<c:if test="${checkAtten.workTime==1}">
				<iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/empSide/checkAttenOk.a" name="right" width="100%" height="100%"></iframe>
			</c:if>

		</div>
	</body>
</html>
