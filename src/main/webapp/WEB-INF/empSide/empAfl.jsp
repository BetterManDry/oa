<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
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
    <div class="panel-head"><span class="icon-magic"> 请假审批</span></div>
    <div class="padding border-bottom">
        <style>
            ul li {
                display: inline;
            }
        </style>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th></th>
            <th>请假类型</th>
            <th>请假开始时间</th>
            <th>请假天数</th>
            <th>审核状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${askForLeaveList}" var="askForLeave">
            <tr>
                <td></td>
                <td>${askForLeave.id}</td>
                <td>${askForLeave.empName}</td>
                <td onclick="showReason('${askForLeave.reason}')">${askForLeave.fromType}</td>
                <td>${askForLeave.startTime}</td>
                <td>${askForLeave.endTime}</td>
                <td>
                    <button class="btn btn-info" target="right" onclick="empSideOk('${askForLeave.id}')">批准</button>
                    <button class="btn btn-warning" onclick="empSideNo('${askForLeave.id}')">不批准</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=1&likeName=${likeName}"
                               aria-label="Previous">
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
                        <c:forEach begin="${pageUtil.pageStart}" end="${pageUtil.pageEnd}" var="i">
                            <li>
                                <a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${i}&likeName=${likeName}">${i}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${pageUtil.pageNum+1<pageUtil.pages}">
                            <li>
                                <a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pageNum+1}&likeName=${likeName}"
                                   aria-label="Next">
                                    <span aria-hidden="true">下一页</span>
                                </a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/demo/toEmpById.a?pageNum=${pageUtil.pages}&likeName=${likeName}"
                               aria-label="Previous">
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

   function showReason(message) {
       alert(message);
   }

   function empSideOk(id) {
       $.post("${pageContext.request.contextPath}/emp/empAflOk.a?id="+id,function (message) {
            alert(message);
           window.location.href="${pageContext.request.contextPath}/demo/toEmpByAfl.a?pageNum=${pageUtil.pageNum}"
       },"text");
   }

   function empSideNo(id) {
       $.post("${pageContext.request.contextPath}/emp/empAflNo.a?id="+id,function (message) {
           alert(message);
           window.location.href="${pageContext.request.contextPath}/demo/toEmpByAfl.a?pageNum=${pageUtil.pageNum}"
       },"text");
   }
</script>

</body>
</html>
