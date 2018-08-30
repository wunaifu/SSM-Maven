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
    <title>Load Panel Content - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Load Panel Content</h2>
<p>Click the refresh button on top right of panel to load content.</p>
<div style="margin:20px 0 10px 0;"></div>
<div id="p" class="easyui-panel" title="Load Panel Content" style="width:700px;height:200px;padding:10px;"
     data-options="
				tools:[{
					iconCls:'icon-reload',
					handler:function(){
						$('#p').panel('refresh', 'demo');
					}
				}]
			">
</div>
<script>

</script>
</body>
</html>
