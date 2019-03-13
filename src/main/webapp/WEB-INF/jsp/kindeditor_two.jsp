<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
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
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<%--<script type="text/javascript" src="js/common.js"></script>--%>

<body>
<div style="padding:10px 10px 10px 10px">
    <form id="itemAddForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>商品图片:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
                    <input type="hidden" name="image"/>
                </td>
            </tr>
            <tr>
                <td>商品描述:</td>
                <td>
                    <textarea style="width:800px;height:300px;visibility:hidden;" name="desc" data-options="required:true"></textarea>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var itemAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){
        //创建富文本编辑器
        itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
        //初始化类目选择和图片上传器
        TAOTAO.init({fun:function(node){
                //根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
                //TAOTAO.changeItemParam(node, "itemAddForm");
            }});
    });
    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#itemAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        //同步文本框中的商品描述
        itemAddEditor.sync();
        //取商品的规格
        //ajax的post方式提交表单
        //$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
        alert($("#itemAddForm").serialize());
        $.post("users/item/save",$("#itemAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增商品成功!');
            }
        });
    }

    function clearForm(){
        $('#itemAddForm').form('reset');
        itemAddEditor.html('');
    }

    var TT = TAOTAO = {
        // 编辑器参数
        kingEditorParams : {
            //指定上传文件参数名称
            filePostName  : "file",
            //指定上传文件请求的url。
            uploadJson : 'users/pic/upload',
            //上传类型，分别为image、flash、media、file
            dir : "image"
        },
        init : function(data){
            // 初始化图片上传组件
            this.initPicUpload(data);
        },
        // 初始化图片上传组件
        initPicUpload : function(data){
            $(".picFileUpload").each(function(i,e){
                var _ele = $(e);
                _ele.siblings("div.pics").remove();
                _ele.after('<div class="pics"><ul></ul></div>');
                // 回显图片
                if(data && data.pics){
                    var imgs = data.pics.split(",");
                    for(var i in imgs){
                        if($.trim(imgs[i]).length > 0){
                            _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                        }
                    }
                }
                //给“上传图片按钮”绑定click事件
                $(e).click(function(){
                    var form = $(this).parentsUntil("form").parent("form");
                    //打开图片上传窗口
                    KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
                        var editor = this;
                        editor.plugin.multiImageDialog({
                            clickFn : function(urlList) {
                                var imgArray = [];
                                KindEditor.each(urlList, function(i, data) {
                                    imgArray.push(data.url);
                                    form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                                });
                                form.find("[name=image]").val(imgArray.join(","));
                                editor.hideDialog();
                            }
                        });
                    });
                });
            });
        },

        createEditor : function(select){
            return KindEditor.create(select, TT.kingEditorParams);
        },

        /**
         * 初始化单图片上传组件 <br/>
         * 选择器为：.onePicUpload <br/>
         * 上传完成后会设置input内容以及在input后面追加<img>
         */
        initOnePicUpload : function(){
            $(".onePicUpload").click(function(){
                var _self = $(this);
                KindEditor.editor(TT.kingEditorParams).loadPlugin('image', function() {
                    this.plugin.imageDialog({
                        showRemote : false,
                        clickFn : function(url, title, width, height, border, align) {
                            var input = _self.siblings("input");
                            input.parent().find("img").remove();
                            input.val(url);
                            input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
                            this.hideDialog();
                        }
                    });
                });
            });
        }
    };
</script>
</body>
</html>
