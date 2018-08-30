<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/plugins/tab/js/framework.js"></script>
    <link rel="stylesheet" type="text/css" href="/plugins/tab/css/import_basic.css"/>
    <link rel="stylesheet" type="text/css" id="skin" prePath="/plugins/tab/" />
    <script type="text/javascript" charset="utf-8" src="/plugins/tab/js/tab.js"></script>
</head>
<body>

<div id="tab_menu"></div>
<div style="width:100%;">
    <div id="page" style="width:100%;height:100%;"></div>
</div>

<script>
    function tabAddHandler(mid,mTitle,mUrl){
        tab.update({
            id :mid,
            title :mTitle,
            url :mUrl,
            isClosed :true
        });
        tab.add({
            id :mid,
            title :mTitle,
            url :mUrl,
            isClosed :true
        });

        tab.activate(mid);
    }

    var tab;
    $( function() {
        tab = new TabView( {
            containerId :'tab_menu',
            pageId :'page',
            cid :'tab1',
            position :"top"
        });
        tab.add( {
            id :'tab1_index1',
            title :"主页",
            url :"/login_default.do",
            isClosed :false
        });

    });

    function mainFrameHead() {
        var page = document.getElementById("page");
        var height = document.documentElement.clientHeight;
        page.style.width = '100%';
        page.style.height = (height-41) + 'px';
    }
    mainFrameHead();
    window.onreset = function () { mainFrameHead() }

</script>


</body>
</html>
