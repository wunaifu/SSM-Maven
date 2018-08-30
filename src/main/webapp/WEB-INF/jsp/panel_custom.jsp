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
    <title>Custom Panel Tools - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
</head>
<body>

<h2>Custom Panel Tools</h2>
<p>Click the right top buttons to perform actions with panel.</p>
<div style="margin:20px 0 10px 0;"></div>
<div class="easyui-panel" title="Custom Panel Tools" style="width:700px;height:200px;padding:10px;"
     data-options="iconCls:'icon-save',closable:true,tools:'#tt'">
    <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
    <ul>
        <li>easyui is a collection of user-interface plugin based on jQuery.</li>
        <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
        <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
        <li>complete framework for HTML5 web page.</li>
        <li>easyui save your time and scales while developing your products.</li>
        <li>easyui is very easy but powerful.</li>
    </ul>
</div>
<div id="tt">
    <a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
    <a href="javascript:void(0)" class="icon-edit" onclick="javascript:alert('edit')"></a>
    <a href="javascript:void(0)" class="icon-cut" onclick="javascript:alert('cut')"></a>
    <a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a>
</div>
</body>
</html>
