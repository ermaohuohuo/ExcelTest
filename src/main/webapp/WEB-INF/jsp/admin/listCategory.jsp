<%--
  Created by IntelliJ IDEA.
  User: sunhu
  Date: 2018/3/31
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp"%>


<html>
<head>
    <title>Title</title>
    <script>
        function fileUpload(){
            var importFile=$("#importFile").val();
            var reg=".xlsx$";
            var patrn=new RegExp(reg);
            if(patrn.exec(importFile)){
                //不做任何事
            }else{
                $.messager.alert("提示","请导入.xls形式的Excel!");
                return false;
            }

            $("#batchAddInfo").form('submit',{
                url:basepath+"jijin/fileUpload",
                onSubmit:function(){},
                success:function(data){
                    data=eval('('+data+')');
                    var flag=data.flag;
                    if(flag){
                        $("#batchDivDialog").window("close");
                        $.messager.alert('提示',"批量新增成功！");
                        searchInfo();
                    }else{
                        $("#batchDivDialog").window("close");
                        $.messager.alert('提示',"批量新增失败！");
                        searchInfo();
                    }
                }
            });


        }
    </script>
</head>
<body>
<form id="batchAddInfo" method="post" enctype="multipart/form-data">
    <div style="width:95%;height:250px;">
        <fieldset>
            <legend style="margin-bottom:10px;"><font color="red">批量新增</font></legend>
            <table>
                <tr><td><span>文件导入</span></td></tr>
                <tr><td><input id="importFile" name="importFile" type="file" style="width:200px;"/></td></tr>
                <tr><td><a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="fileUpload()" iconCls="icon-reload">导入</a></td></tr>
                <tr><td><a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="downloadFile()" iconCls="icon-print">模板下载</a></td></tr>
            </table>
        </fieldset>
    </div>
</form>
</body>
</html>
