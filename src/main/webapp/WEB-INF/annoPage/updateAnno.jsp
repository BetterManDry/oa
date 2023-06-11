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
  <div class="panel-head" id="add"><strong><span class="icon-foursquare"></span> 修改公告</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/anno/upAnnoMeth.a">
		<input type="hidden" name="pageNum" value="${pageNum}"/>
		<input type="hidden" name="annoId" value="${anno.annoId}"/>
      <div class="form-group">
        <div class="label">
          <label>公告名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${anno.annoName}" name="annoName"/>
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>公告内容：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${anno.annoContent}" name="annoContent"/>
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
					   value="${anno.startDate}" name="startDate"/>
				<span></span>
				<script>
					laydate.render({
						elem: '#hiredate' //指定元素
					});
				</script>
			</div>
			<div class="form-group">
				<div class="label">
					<label>举行天数：</label>
				</div>
				<div class="field">
					<input type="text" name="annoDays" class="input w50" value="${anno.annoDays}">
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