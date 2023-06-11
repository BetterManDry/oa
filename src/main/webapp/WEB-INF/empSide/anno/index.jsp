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
	<div class="panel-head"><span class="icon-magic">公告</span></div>
	<table class="table table-hover text-center">
		<tr>
			<th></th>
			<th>编号</th>
			<th>公告名</th>
			<th>发布人</th>
			<th>开始日期</th>
			<th>举行天数</th>
		</tr>
		<c:forEach items="${annoList}" var="anno">
			<tr>
				<td></td>
				<td>${anno.annoId}</td>
				<td onclick="showAnnoContent('${anno.annoContent}')">${anno.annoName}</td>
				<td>${anno.annoBy}</td>
				<td>${anno.startDate}</td>
				<td>${anno.annoDays}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li>
							<a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a?pageNum=1" aria-label="Previous">
								<span aria-hidden="true">首页</span>
							</a>
						</li>
						<c:if test="${pageUtil.pageNum-1>0}">
							<li>
								<a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a?pageNum=${pageUtil.pageNum-1}" aria-label="Previous">
									<span aria-hidden="true">上一页</span>
								</a>
							</li>
						</c:if>
						<c:forEach begin="${pageUtil.pageStart}" end="${pageUtil.pageEnd}" var="i" >
							<li><a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a?pageNum=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${pageUtil.pageNum+1<pageUtil.pages}">
							<li>
								<a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a?pageNum=${pageUtil.pageNum+1}" aria-label="Next">
									<span aria-hidden="true">下一页</span>
								</a>
							</li>
						</c:if>
						<li>
							<a href="${pageContext.request.contextPath}/empSide/anno/toAnnoById.a?pageNum=${pageUtil.pages}" aria-label="Previous">
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

	function dele(annoId) {
		alert(annoId)
		$.post("${pageContext.request.contextPath}/anno/delAnno.a?annoId=" + annoId,function (message) {
			alert(message);
			window.location.href="${pageContext.request.contextPath}/demo/toAnnoById.a?pageNum=${pageUtil.pageNum}"
		},"text")
	}
	function showAnnoContent(annoContent) {
		alert(annoContent);
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
				$.post("${pageContext.request.contextPath}/anno/delMore.a?list="+list,function (message) {
					alert(message);
					window.location.href="${pageContext.request.contextPath}/demo/toAnnoById.a?pageNum=${pageUtil.pageNum}";
				},"text");
			}else {
				return false;
			}
		})
	})
</script>

</body>
</html>
