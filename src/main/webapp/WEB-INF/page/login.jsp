<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

	</head>
	<body>
		<div class="bg"></div>
		<div class="container">
			<div class="line bouncein">
				<div class="xs6 xm4 xs3-move xm4-move">
					<div style="height:150px;"></div>
					<div class="media media-y margin-big-bottom">
					</div>
					<form action="${pageContext.request.contextPath}/login.a" method="post">
						<div class="panel loginbox" style="margin-top: -100px;">
							<div class="text-center margin-big padding-big-top">
								<h1>后台管理中心</h1>
							</div>
							<div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="text" autofocus="autofocus" class="input input-big" name="adminCode" value="${cookie.aCode.value}" placeholder="登录账号" data-validate="required:请填写账号" />
										<span class="icon icon-user margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input input-big" name="adminPwd" value="${cookie.aPwd.value}" placeholder="登录密码" data-validate="required:请填写密码" />
										<span class="icon icon-key margin-small"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field">
										<input type="text" class="input input-big" name="valiCode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
										<img src="${pageContext.request.contextPath}/demo/createCode.a" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;"
										 onclick="this.src=this.src+'?'">
									</div>
								</div>
								<div class="checkbox">
									<label style="font-family: 宋体;font-weight: bold;color: gray;">
										<input style="vertical-align: middle;" type="checkbox" name="checkFlag" checked="checked" value="">
										两周内自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
							</div>
							<div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
						</div>
					</form>
					<div style="padding:30px;"><a href="${pageContext.request.contextPath}/empSide/login.a	">我是员工，进入员工页面</a></div>
				</div>
			</div>
		</div>
	</body>
</html>
