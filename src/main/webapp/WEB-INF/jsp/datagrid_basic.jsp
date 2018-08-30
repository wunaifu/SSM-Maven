<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30 0030
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic DataGrid</h2>
<p>The DataGrid is created from markup, no JavaScript code needed.</p>
<div style="margin:20px 0;"></div>

<table class="easyui-datagrid" title="Basic DataGrid" style="width:100%"
       data-options="singleSelect:true,collapsible:true,url:'users/list',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'firstname'">firstname</th>
        <th data-options="field:'lastname'">lastname</th>
        <th data-options="field:'phone',align:'right'">phone</th>
        <th data-options="field:'email',align:'center'">email</th>
    </tr>
    </thead>
</table>

</body>
</html>
