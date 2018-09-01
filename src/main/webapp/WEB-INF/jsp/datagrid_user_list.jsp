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
    <title>jQuery EasyUI CRUD Demo</title>

    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.6.2/demo/demo.css">
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            color:#666;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.6.2/jquery.easyui.min.js"></script>

</head>
<body>
<h2>EasyUI 创建 CRUD 应用</h2>
<div class="demo-info" style="margin-bottom:10px">
    <div class="demo-tip icon-tip">&nbsp;</div>
    <div>提示.</div>
</div>

<table id="dg" title="用户列表" class="easyui-datagrid"  style="width:100%;height:600px;"
       toolbar="#toolbar"
       url="user/list"
       data-options="
            fitColumns:true,
            rownumbers:true,
            singleSelect:true,
            autoRowHeight:true,
            pagination:true,
            pageSize:10"
        >
    <thead>
    <tr>
        <th field="id" width="50">ID</th>
        <th field="phone" width="80">手机号</th>
        <th field="password" width="50">密码</th>
        <th field="nickname" width="50">昵称</th>
        <th field="name" width="50">名字</th>
        <th field="age" width="50">年龄</th>
        <th field="habit" width="50">爱好</th>
        <th field="birthday" width="50">生日</th>
        <th field="address" width="50">地址</th>
        <th field="weigh" width="50">体重</th>
        <th field="height" width="50">身高</th>
        <th field="xingZuo" width="50">星座</th>
        <th field="signature" width="50">个性签名</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改用户</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">移除用户</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">用户信息</div>
    <form id="fm" method="post" novalidate>
        <div class="fitem">
            <label>手机号:</label>
            <input name="phone" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>密码:</label>
            <input name="password" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>名字:</label>
            <input name="name" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>昵称:</label>
            <input name="nickname" class="easyui-validatebox" required="true"validType="email">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<script>
    var url;
    function newUser() {
        $('#dlg').dialog('open').dialog('setTitle', '添加用户');
        $('#fm').form('clear');
        url = 'user/save';
    }
    function editUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('setTitle', '编辑用户');
            $('#fm').form('load', row);
            url = 'user/update/'+row.id;
        }
    }
    function saveUser() {
        $('#fm').form('submit',{
            url:url,
            onSubmit:function () {
                return $(this).form('validate');
            },
            success:function (result) {
                if (result=='success') {
                    $('#dlg').dialog('close');//关闭弹框
                    $('#dg').datagrid('reload');//重新加载网格
                } else {
                    console.log("前："+result);
                    var result = eval('('+result+')');//转换成json对象
                    console.log("后："+result.status+result.msg);
                    $.messager.show({
                        title:"错误",
                        msg:result.msg
                    })
                }
            }
        });
    }
    function removeUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm("提示",'你确定删除该用户吗？',function (r) {
                if (r) {
                    $.post('user/del',{phone: row.phone}, function (result) {
                        console.log(result);
                        if (result.msg=='OK') {
                            $('#dg').datagrid('reload');//重新加载网格
                        } else {
                            $.messager.show({
                                title: "错误",
                                msg: result.msg
                            })
                        }
                    }, 'json');
                }
            })
        }
    }

    function getData(){
        $.get('user/list', function (result) {
            console.log(result);
            return result;
        }, 'json');
    }

    function pagerFilter(data){
        if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage:function(pageNum, pageSize){
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                pager.pagination('refresh',{
                    pageNumber:pageNum,
                    pageSize:pageSize
                });
                dg.datagrid('loadData',data);
            }
        });
        if (!data.originalRows){
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }

    $(function(){
        $('#dg').datagrid({loadFilter:pagerFilter});
    });
</script>
</body>
</html>

