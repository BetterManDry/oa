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
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-magic"> 添加员工</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/emp/addEmpCon.a" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${pageNum}">
      <div class="form-group">

        <div class="label">
          <label>员工姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="empName"
		   placeholder="请输入姓名" />
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>工种：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="" name="empJob"
	  		   placeholder="请输入工种"/>
	      <span></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>月薪：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="" name="empSal"
	  		   placeholder="请输入月薪"/>
	      <span></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>入职日期：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50"
		   id="hiredate"
		   value="" name="empHiredate"
	  		   placeholder="请选择职日期"/>
	      <span></span>
		  <script>
			 laydate.render({
			   elem: '#hiredate' //指定元素
			 });
		  </script>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>头像上传:</label>
	    </div>
		  <div class="field">
			  <input type="file" class="input w50" value="" name="upImg"/>
			  <span></span>
		  </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>所在部门：</label>
	    </div>
	    <div class="field">
	      <select name="deptNo" class="input w50">
			  <c:forEach items="${depts}" var="dept">
				  <option value="${dept.deptNo}">${dept.deptName}</option>
			  </c:forEach>
	      </select>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label></label>
	    </div>
	    <div class="field">
	      <input class="button bg-main icon-check-square-o" type="submit" value="提交"/>
	  		  <button type="button" style="width: 110px;" class="button bg-green" onclick="javascript:history.back(-1)"> 返回</button>   
	    </div>
	  </div>    
    </form>
  </div>
</div>

</body></html>