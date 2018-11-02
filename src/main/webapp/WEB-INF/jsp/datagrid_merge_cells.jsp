<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28 0028
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>数据表格合并单元格</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
</head>
<body>
<h2>数据表格合并单元格</h2>
<p>数据表格合并单元格.</p>
<div style="margin:20px 0;"></div>
<table class="easyui-datagrid" title="Merge Cells for DataGrid" style="width:100%;"
       data-options="
				rownumbers: true,
				singleSelect: true,
				iconCls: 'icon-save',
				url: 'user/list',
				method: 'get',
				onLoadSuccess: onLoadSuccess
			">
    <thead>
    <tr>
        <th field="id" width="80">ID</th>
        <th field="phone" width="130">手机号</th>
        <th field="password" width="80">密码</th>
        <th field="nickname" width="80">昵称</th>
        <th field="name" width="80">名字</th>
        <th field="age" width="50">年龄</th>
        <th field="habit" width="80">爱好</th>
        <th field="birthday" width="50">生日</th>
        <th field="address" width="50">地址</th>
        <th field="weigh" width="50">体重</th>
        <th field="height" width="50">身高</th>
        <th field="xingZuo" width="50">星座</th>
        <th field="signature" width="50">个性签名</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    function onLoadSuccess(data){
        var merges = [{
            index: 2,
            rowspan: 2
        },{
            index: 5,
            rowspan: 2
        },{
            index: 7,
            rowspan: 2
        }];
        for(var i=0; i<merges.length; i++){
            $(this).datagrid('mergeCells',{
                index: merges[i].index,
                field: 'id',
                rowspan: merges[i].rowspan
            });
        }
    }
</script>
</body>
</html>
