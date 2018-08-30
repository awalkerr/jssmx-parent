<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/plugins/tab/js/framework.js"></script>
    <link rel="stylesheet" type="text/css" href="/plugins/tab/css/import_basic.css" />
    <link rel="stylesheet" type="text/css" id="skin" prePath="plugins/tab/"/>
    <!--默认相对于根目录路径为../，可添加prePath属性自定义相对路径，如prePath="<%=request.getContextPath()%>"-->
    <script type="text/javascript" charset="utf-8" src="/plugins/tab/js/tab.js"></script>
</head>
<body>
<div id="tab_menu"></div>
<div style="width:100%;">
    <div id="page" style="width:100%;height:100%;"></div>
</div>
</body>
<script type="text/javascript">

    function tabAddHandler(id, title, url) {
        tab.update({
            id: id,
            title: title,
            url: url,
            isClosed: true
        });
        tab.add({
            id: id,
            title: title,
            url: url,
            isClosed: true
        });

        tab.activate(id);
    }

    var tab;
    $(function () {
        tab = new TabView({
            containerId: 'tab_menu',
            pageId: 'page',
            cid: 'tab1',
            position: "top"
        });
        tab.add({
            id: 'tab1_index1',
            title: "主页",
            url: "<%=basePath%>login_default.do",
            isClosed: false
        });
        /**tab.add( {
		id :'tab1_index1',
		title :"主页",
		url :"/per/undoTask!gettwo",
		isClosed :false
	});
         **/
    });

    function cMainFrameTab() {
        var mainTab = document.getElementById("page");
        var heightTab = document.documentElement.clientHeight;
        mainTab.style.width = '100%';
        mainTab.style.height = (heightTab - 41) + 'px';
    }

    cMainFrameTab();
    window.onresize = function () {
        cMainFrameTab();
    };

</script>
</html>

