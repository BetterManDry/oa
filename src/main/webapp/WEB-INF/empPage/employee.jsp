<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin1.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
		<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/app.js"></script>
		<script src="${pageContext.request.contextPath}/js/plugs.js"></script>
	</head>
	<body>
			<div class="panel admin-panel" style="border: 1px solid #ddd;">
				<div class="panel-head"><span class="icon-magic"> 员工管理</span></div>
				<div class="padding border-bottom">
					<style>
						ul li{
				display: inline;
			}
		</style>
					<ul class="search">
						<li>
							<a href="${pageContext.request.contextPath}/emp/toAddEmp.a?pageNum=${pageUtil.pages}" style="margin-top:10px ;" class="btn btn-success" target="right">添加员工</a>
							<button style="margin-top:10px ;" class="btn btn-danger" id="delMore">批量删除</button>
						</li>

						<li>
							<form action="${pageContext.request.contextPath}/demo/toEmpById.a">
								<div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:220px;top:65px"></div>
								<div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:10px;top:68px">
									<div class="am-input-group am-input-group-sm">
										<input type="text" name="likeName" value="${likeName}" class="am-form-field" placeholder="请输入员工姓名"/>
										<span class="am-input-group-btn">
										<input type="submit" id="subBut" class="btn btn-primary" value="查询"/></span>
									</div>
								</div>
							</form>
		</li>
		</ul>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th></th>
				<th>编号</th>
				<th>姓名</th>
				<th>工种</th>
				<th>月薪</th>
				<th>入职日期</th>
				<th>员工头像</th>
				<th>所在部门</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
					<tr>
						<td>
							<input type="checkbox" name="id[]" value="${emp.empNo}" />
						</td>
						<td>${emp.empNo}</td>
						<td>${emp.empName}</td>
						<td>${emp.empJob}</td>
						<td>${emp.empSal}</td>
						<td>${emp.empHiredate}</td>
						<td><img src="${pageContext.request.contextPath}/fileupload/${emp.empPhoto}" width="40px" height="40px"></td>
						<td>${emp.deptName}</td>
						<td>
							<a href="${pageContext.request.contextPath}/emp/toUpdateEmp.a?empNo=${emp.empNo}&pageNum=${pageUtil.pageNum}&likeName=${likeName}" class="btn btn-info" target="right">修改</a>
<%--							<a href="${pageContext.request.contextPath}/emp/delEmp.a?empNo=${emp.empNo}" class="btn btn-warning">删除</a>--%>
							<button class="btn btn-warning" onclick="dele(${emp.empNo})">删除</button>
						</td>
					</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li>
								<a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=1&likeName=${likeName}" aria-label="Previous">
									<span aria-hidden="true">首页</span>
								</a>
							</li>
							<c:if test="${pageUtil.pageNum-1>0}">
								<li>
									<a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pageNum-1}&likeName=${likeName}"
									   aria-label="Previous">
										<span aria-hidden="true">上一页</span>
									</a>
								</li>
							</c:if>
							<c:forEach begin="${pageUtil.pageStart}" end="${pageUtil.pageEnd}" var="i" >
								<li><a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${i}&likeName=${likeName}">${i}</a></li>
							</c:forEach>
							<c:if test="${pageUtil.pageNum+1<pageUtil.pages}">
								<li>
									<a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pageNum+1}&likeName=${likeName}" aria-label="Next">
										<span aria-hidden="true">下一页</span>
									</a>
								</li>
							</c:if>
							<li>
								<a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pages}&likeName=${likeName}" aria-label="Previous">
									<span aria-hidden="true">尾页</span>
								</a>
							</li>
						</ul>
					</nav>
				</td>
			</tr>
		</table>
		</div>
		</form>
		<script type="text/javascript">

			function dele(empNo) {
				alert(empNo)
				$.post("${pageContext.request.contextPath}/emp/delEmp.a",{"empNo":empNo},function (message) {
					alert(message);
					window.location.href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pageNum}&likeName=${likeName}"
				},"text")
			}

			$(function () {
				$("#delMore").click(function (){
					var t = confirm("您确认要删除选中的内容吗？");
					if (t == true) {
						var list = [];
						$("input[name='id[]']").each(function () {
							if ($(this).prop("checked")) {
								list.push($(this).val());
							}
						})
						alert(list)
						$.post("${pageContext.request.contextPath}/emp/delMore.a?list="+list,function (message) {
							alert(message);
							window.location.href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pageNum}&likeName=${likeName}";
						},"text");
					}else {
						return false;
					}
				})
			})
		</script>
		
	</body>
</html>
