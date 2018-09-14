<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30 0030
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EasyUI例子整合</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/locale/easyui-lang-zh_CN.js"></script>
    <style type="text/css">
        .content {
            padding: 10px 10px 10px 10px;
            margin: 3px;
        }
    </style>
</head>
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">

        <li>
            <span>面板Panel</span>
            <ul>
                <li data-options="attributes:{'url':'panel_basic'}">基础面板</li>
                <li data-options="attributes:{'url':'panel_tool'}">面板工具</li>
                <li data-options="attributes:{'url':'panel_custom'}">用户面板工具</li>
                <li data-options="attributes:{'url':'panel_load'}">载入面板内容</li>
            </ul>
        </li>
        <li>
            <span>数据表格DataGrid</span>
            <ul>
                <li data-options="attributes:{'url':'datagrid_user_list'}">数据表格</li>
                <li data-options="attributes:{'url':'datagrid_basic'}">基础数据表格</li>
                <li data-options="attributes:{'url':'datagrid_pagination'}">数据表格的客户端分页</li>
                <li data-options="attributes:{'url':'treegrid_pagination'}">树表格的客户端分页</li>
                <li data-options="attributes:{'url':'datagrid_row_edit'}">数据表格的行编辑</li>
                <li data-options="attributes:{'url':'kindeditor'}">图片上传，富文本编辑器</li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs">
        <div id="mycenter" title="首页" style="padding:20px;" data-options="tools:[{
                                iconCls:'icon-reload',
                                handler:function(){
                                    $('#mycenter').panel('refresh', 'index_home');
                                }
                            }]">
            <div >
                <h1>哈哈哈，首页</h1>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab",node.text);
                    if(tab){
                        tabs.tabs("select",node.text);
                    }else{
                        tabs.tabs('add',{
                            title:node.text,//树名
                            href: node.attributes.url,//跳转链接
                            closable:true,//可关闭
                            refresh:true,
                            bodyCls:"content",//面板中的样式
                            tools:[{
                                iconCls:'icon-reload',
                                handler:function(){
                                    var currTab =  tabs.tabs('getSelected'); //获得当前tab
                                    var url = $(currTab.panel('options').content).attr('src');
                                    currTab.panel('refresh', url);//刷新
                                }
                            }]
                        });
                    }
                }
            }
        });
    });
</script>
</body>
</html>
