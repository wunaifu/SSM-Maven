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
    <title>Basic Panel - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic Panel</h2>
<p>The panel is a container for other components or elements.</p>
<div style="margin:20px 0 10px 0;">
    <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
    <a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
</div>
<div class="easyui-panel" title="Basic Panel标题" style="width:100%;height:100%;padding:10px;">
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
<script>


</script>
</body>
</html>
