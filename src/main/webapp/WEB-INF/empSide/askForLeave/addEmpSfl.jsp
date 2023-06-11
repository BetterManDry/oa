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
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-foursquare"></span> 请假申请</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/empSide/insert.a">
            <input type="hidden" name="empId" value="${sessionScope.emp.empNo}" />
            <input type="hidden" name="pageNum" value="${pageNum}" />
            <div class="form-group">
                <div class="label">
                    <label>请假类别：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="fromType" value="${askForLeave.fromType}" placeholder="请输入请假类别"/>
                    <span></span>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>请假原因：</label>
                </div>
                <div class="field">
                    <textarea rows="10" cols="50" name="reason" value="${askForLeave.reason}" placeholder="请输入请假原因"></textarea>
                    <span></span>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>开始日期：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50"
                           id="hiredate"
                           value="${askForLeave.startTime}" name="startTime"
                           placeholder="请选择职日期"/>
                    <span></span>
                    <script>
                        laydate.render({
                            elem: '#hiredate' //指定元素
                        });
                    </script>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>时长：</label>
                    </div>
                    <div class="field">
                        <input type="text" name="endTime" value="${askForLeave.endTime}" class="input w50" placeholder="请输入天数">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    <button type="button" style="width: 110px;" class="button bg-green" onclick="javascript:history.back(-1)"> 返回</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body></html>