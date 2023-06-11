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
    <div class="panel-head"><span class="icon-foursquare"> 请假记录</span></div>
    <div class="padding border-bottom">
        <ul class="search">
            <li>
                <a href="${pageContext.request.contextPath}/empSide/askForLeave/toAddEmpSfl.a?pageNum=${pageUtil.pageNum}" style="margin-top:10px ;" class="btn btn-success" target="right">请假申请</a>
            </li>
        </ul>
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
            <td onclick="showReason('${askForLeave.reason}')">${askForLeave.fromType}</td>
            <td>${askForLeave.startTime}</td>
            <td>${askForLeave.endTime}</td>
<%--            <td>${askForLeave.state}</td>--%>
            <c:if test="${askForLeave.state==0}">
                <td>审核中</td>
            </c:if>
            <c:if test="${askForLeave.state==1}">
                <td>审核通过</td>
            </c:if>
            <c:if test="${askForLeave.state==2}">
                <td>审核失败</td>
            </c:if>
            <td>
                <c:if test="${askForLeave.state==0}">
                    <a href="${pageContext.request.contextPath}/empSide/askForLeave/updateAfl.a?pageNum=${pageUtil.pageNum}&id=${askForLeave.id}"
                       class="btn btn-info" target="right">修改</a>
                </c:if>
                <c:if test="${askForLeave.state==1}">
                    <a href="" class="btn btn-info" target="right">已通过</a>
                </c:if>
                <c:if test="${askForLeave.state==2}">
                    <a href="" class="btn btn-info" target="right">审核失败,重新填写</a>
                </c:if>
            </td>
        </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a?pageNum=1" aria-label="Previous">
                                <span aria-hidden="true">首页</span>
                            </a>
                        </li>
                        <c:if test="${pageUtil.pageNum-1>0}">
                            <li>
                                <a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a?pageNum=${pageUtil.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">上一页</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach begin="${pageUtil.pageStart}" end="${pageUtil.pageEnd}" var="i" >
                            <li><a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a?pageNum=${i}">${i}</a></li>
                        </c:forEach>
                        <c:if test="${pageUtil.pageNum+1<pageUtil.pages}">
                            <li>
                                <a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a?pageNum=${pageUtil.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">下一页</span>
                                </a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/empSide/askForLeave/toSeeAfl.a?pageNum=${pageUtil.pages}" aria-label="Previous">
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
    function showReason(reason) {
        alert(reason);
    }



</script>

</body>
</html>
