<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
				<div class="panel-head"><span class="icon-foursquare"> 部门管理</span></div>
				<div class="padding border-bottom">
					<style>
						ul li{
				display: inline;
			}
		</style>
					<ul class="search">
						<li>
							<a href="${pageContext.request.contextPath}/dept/toAddDept.a?pageNum=${pageUtil.pages}" style="margin-top:10px ;" class="btn btn-success" target="right">添加部门</a>
							<button id="delMore" style="margin-top:10px ;" class="btn btn-danger">批量删除</button>
						</li>

						<li>
							<form action="${pageContext.request.contextPath}/demo/toDeptById.a" method="post">
								<div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:10px;top:68px">
									<div class="am-input-group am-input-group-sm">
										<input class="am-form-field" placeholder="请输入部门名称" name="likeName" value="${likeName}"  type="text">
										<span class="am-input-group-btn"> 
											<button type="submit" class="btn btn-primary">查询</button></span>
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
				<th>部门名称</th>
				<th>部门地址</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${deptList}" var="dept">
					<tr>
						<td>
							<input type="checkbox" name="id[]" value="${dept.deptNo}"/>
						</td>
						<td>${dept.deptNo}</td>
						<td>${dept.deptName}</td>
						<td>${dept.deptAddr}</td>
						<td>
							<a href="${pageContext.request.contextPath}/dept/toUpdateDept.a?deptNo=${dept.deptNo}&pageNum=${pageUtil.pageNum}&likeName=${likeName}"
							   class="btn btn-info" target="right">修改</a>
<%--							<a href="${pageContext.request.contextPath}/dept/deleleDept.a?deptNo=${dept.deptNo}"--%>
<%--							   class="btn btn-warning">删除</a>--%>
							<button class="btn btn-warning" onclick="dele(${dept.deptNo})">删除</button>
						</td>
					</tr>
			</c:forEach>

			<tr>
				<td colspan="8">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li>
								<a href="${pageContext.request.contextPath}/demo/toDeptById.a?pageNum=1&likeName=${likeName}" aria-label="Previous">
									<span aria-hidden="true">首页</span>
								</a>
							</li>
							<c:if test="${pageUtil.pageNum-1>0}">
								<li>
									<a href="${pageContext.request.contextPath}/demo/toDeptById.a?pageNum=${pageUtil.pageNum-1}&likeName=${likeName}" aria-label="Previous">
										<span aria-hidden="true">上一页</span>
									</a>
								</li>
							</c:if>
							<c:forEach begin="${pageUtil.pageStart}" end="${pageUtil.pageEnd}" var="i" >
								<li><a href="${pageContext.request.contextPath}/demo/toDeptById.a?pageNum=${i}&likeName=${likeName}">${i}</a></li>
							</c:forEach>
							<c:if test="${pageUtil.pageNum+1<pageUtil.pages}">
								<li>
									<a href="${pageContext.request.contextPath}/demo/toDeptById.a?pageNum=${pageUtil.pageNum+1}&likeName=${likeName}" aria-label="Next">
										<span aria-hidden="true">下一页</span>
									</a>
								</li>
							</c:if>
							<li>
								<a href="${pageContext.request.contextPath}/demo/toDeptById.a?pageNum=${pageUtil.pages}&likeName=${likeName}" aria-label="Previous">
									<span aria-hidden="true">尾页</span>
								</a>
							</li>
						</ul>
					</nav>
					</div>
				</td>
			</tr>
		</table>
		</div>
		</form>
		<script type="text/javascript">
			function dele(deptNo) {
				$.post("${pageContext.request.contextPath}/dept/deleleDept.a",{"deptNo":deptNo},function (message) {
					alert(message);
					window.location.href="${pageContext.request.contextPath}/demo/toDeptById.a?likeName=${likeName}&pageNum=${pageUtil.pageNum}"
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
						$.post("${pageContext.request.contextPath}/dept/delMore.a?list="+list,function (message) {
							alert(message);
							window.location.href="${pageContext.request.contextPath}/demo/toDeptById.a?likeName=${likeName}&pageNum=${pageUtil.pageNum}";
						},"text");
					}else {
						return false;
					}
				})
			})


		</script>
		
	</body>
</html>
