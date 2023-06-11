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
  <div class="panel-head" id="add"><strong><span class="icon-magic"> 修改员工</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/emp/updateEmpjsp.a" enctype="multipart/form-data">
		<%--传递主键到修改处理器  数据回显不需要主键  但是修改需要--%>
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="likeName" value="${likeName}">
		<input type="hidden" name="empNo" value="${emp.empNo}">
      <div class="form-group">
        <div class="label">
          <label>员工姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${emp.empName}" name="empName"/>
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>工种：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${emp.empJob}" name="empJob"/>
	      <span></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>月薪：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${emp.empSal}" name="empSal"/>
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
		   value="${emp.empHiredate}" name="empHiredate"/>
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
	      <label>员工头像：</label>
	    </div>
		  <div class="field">
			  <img src="${pageContext.request.contextPath}/fileupload/${emp.empPhoto}" width="40px" height="40px">
			  <span></span>
		  </div>
	  </div>
		<div class="form-group">
			<div class="label">
				<label>修改头像：</label>
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
				<c:if test="${dept.deptNo == emp.deptNo}">
					<option value="${dept.deptNo}" selected="selected">${dept.deptName}</option>
				</c:if>
				<c:if test="${dept.deptNo != emp.deptNo}">
					<option value="${dept.deptNo}">${dept.deptName}</option>
				</c:if>
			</c:forEach>
	      </select>
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