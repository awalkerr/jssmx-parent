<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar" class="sidebar responsive">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">

            <button class="btn btn-info" onclick="" title="切换菜单">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-success" title="UI实例" onclick="window.open('/static/html_UI/html');">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <!-- #section:basics/sidebar.layout.shortcuts -->
            <button class="btn btn-warning" title="" id="adminDir">
                <i class="ace-icon fa fa-book"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>

            <!-- /section:basics/sidebar.layout.shortcuts -->
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="">
            <a href="main/index">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text">后台首页</span>
            </a>
            <b class="arrow"></b>
        </li>

        <c:forEach items="${menuList}" var="menu1">
            <c:if test="${menu1.hasMenu && '1' == menu1.state}">
                <li class="" id="lm${menu1.id}">
                    <a style="cursor:pointer;" class="dropdown-toggle">
                        <i class="${menu1.icon == null ? 'menu-icon fa fa-leaf black' : menu1.icon}">
                            <span class="menu-text">
                                    ${menu1.name }
                            </span>
                            <c:if test="${'[]' != menu1.subMenu}"><b class="arrow fa fa-angle-down"></b></c:if>
                        </i>
                    </a>
                    <b class="arrow"></b>

                    <c:if test="${'[]' != menu1.subMenu}">
                        <ul class="submenu">
                            <c:forEach items="${menu1.subMenu}" var="menu2">
                                <c:if test="${menu2.hasMenu && '1' == menu2.state}">
                                    <li class="" id="z${menu2.id }">
                                        <a style="cursor:pointer;" <c:if test="${not empty menu2.url && '#' != menu2.url}"> target="mainFrame" onclick="isMenu('z${menu2.id }','lm${menu1.id }','${menu2.name }','${menu2.url }')"</c:if><c:if test="${'[]' != menu2.subMenu}"> class="dropdown-toggle"</c:if>>
                                            <i class="${menu2.icon == null ? 'menu-icon fa fa-leaf black' : menu2.icon}"></i>
                                                ${menu2.name }
                                            <c:if test="${'[]' != menu2.subMenu}"><b class="arrow fa fa-angle-down"></b></c:if>
                                        </a>
                                        <b class="arrow"></b>
                                        <c:if test="${'[]' != menu2.subMenu}">
                                            <ul class="submenu">
                                                <c:forEach items="${menu2.subMenu}" var="menu3">
                                                    <c:if test="${menu3.hasMenu && '1' == menu3.state}">
                                                        <li class="" id="m${menu3.id }">
                                                            <a style="cursor:pointer;" <c:if test="${not empty menu3.url && '#' != menu3.url}"> target="mainFrame" onclick="isMenu('m${menu3.id }','z${menu2.id }','${menu3.name }','${menu3.url }')"</c:if><c:if test="${'[]' != menu3.subMenu}"> class="dropdown-toggle"</c:if>>
                                                                <i class="${menu3.icon == null ? 'menu-icon fa fa-leaf black' : menu3.icon}"></i>
                                                                    ${menu3.name }
                                                                <c:if test="${'[]' != menu3.subMenu}"><b class="arrow fa fa-angle-down"></b></c:if>
                                                            </a>
                                                            <b class="arrow"></b>

                                                            <c:if test="${'[]' != menu3.subMenu}">
                                                                <ul class="submenu">
                                                                    <c:forEach items="${menu3.subMenu}" var="menu4">
                                                                        <c:if test="${menu4.hasMenu && '1' == menu4.state}">
                                                                            <li class="" id="n${menu4.id }">
                                                                                <c:if test="${'[]' != menu4.subMenu}">
                                                                                    <a style="cursor:pointer;" target="mainFrame" onclick="isMenu('n${menu4.id }','m${menu3.id }','${menu4.name }','menu/otherListMenu.do?id=${menu4.id }')">
                                                                                </c:if>
                                                                                <c:if test="${'[]' == menu4.subMenu}">
                                                                                    <a style="cursor:pointer;" target="mainFrame" <c:if test="${not empty menu4.url && '#' != menu4.url}"> target="mainFrame" onclick="isMenu('n${menu4.id }','m${menu3.id }','${menu4.name }','${menu4.url }')"</c:if>>
                                                                                </c:if>
                                                                                <i class="${menu4.icon == null ? 'menu-icon fa fa-leaf black' : menu4.icon}"></i>
                                                                                    ${menu4.name }
                                                                                </a>
                                                                                <b class="arrow"></b>
                                                                            </li>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </ul>
                                                            </c:if>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </c:if>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:if>
        </c:forEach>

    </ul><!-- /.nav-list -->

    <!-- #section:basics/sidebar.layout.minimize -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>