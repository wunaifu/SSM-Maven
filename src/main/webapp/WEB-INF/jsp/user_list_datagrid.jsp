<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28 0028
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>CRUD 数据网格（DataGrid）</title>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">

    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/plugins/jquery.datagrid.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#dg').datagrid({
                url: 'users/list',
                saveUrl: 'users/save',
                updateUrl: 'users/update',
                destroyUrl: 'users/del'
                // url：从服务器端检索用户数据。
                // saveUrl：保存一个新的用户数据。
                // updateUrl：更新一个已存在的用户数据。
                // destroyUrl：删除一个已存在的用户数据。
            });
        });
    </script>
</head>
<body>
<h2>EasyUI 创建 CRUD 应用</h2>
<div class="demo-info" style="margin-bottom:10px">
    <div class="demo-tip icon-tip">&nbsp;</div>
    <div>双击编辑.</div>
</div>

<table id="dg" title="My Users" style="width:100%;"
       toolbar="#toolbar" pagination="true" idField="id"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="firstname" width="50" editor="{type:'validatebox',options:{required:true}}">First Name</th>
        <th field="lastname" width="50" editor="{type:'validatebox',options:{required:true}}">Last Name</th>
        <th field="phone" width="50" editor="text">Phone</th>
        <th field="email" width="50" editor="{type:'validatebox',options:{validType:'email'}}">Email</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').datagrid('addRow')">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').datagrid('destroyRow')">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').datagrid('saveRow')">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').datagrid('cancelRow')">取消</a>
</div>
</body>
</html>

