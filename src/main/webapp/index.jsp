<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<body>
<input type="text"
            value="<fmt:formatDate value="<%=new Date()%>"
            pattern="yyyy-MM-dd HH:mm:ss"/>"/>
<br/>
<h3><a href="user_list">1、EasyUI例子 - EasyUI创建CRUD应用</a></h3>
<h3><a href="user_list_datagrid">2、EasyUI例子 - EasyUI 创建 CRUD 数据网格（DataGrid）</a></h3>
<h3><a href="index_easyui">EasyUI例子整合</a></h3>
<h3><a href="kindeditor_two">富文本编辑器</a></h3>
<h2>网站开发页面</h2>
<h2>尽情装逼吧</h2>
<h2>测试多文件上传</h2>
<form action="/starry/user/uploadFileList" method="post" enctype="multipart/form-data" >

    <input type="file" name="file"><br/>
    <input type="file" name="file"><br/>
    <input type="file" name="file"><br/>
    <input type="submit"value="提交"/>
</form>
<h2></h2>
<h2>测试单文件上传</h2>
<form action="/starry/user/uploadFile" method="post" enctype="multipart/form-data" >

    <input type="file" name="file"><br/>
    <input type="submit"value="提交"/>
</form>
<a href="/import/template"><h2>测试导出Excel模版文档</h2></a>
<a href="/export"><h2>测试导出Excel内容文档</h2></a>
<h2>测试导入读取Excel文档</h2>
<form action="/import2" method="post" enctype="multipart/form-data" >

    <input type="file" name="multipartFile"><br/>
    <input type="submit"value="提交"/>
</form>

</body>
</html>
