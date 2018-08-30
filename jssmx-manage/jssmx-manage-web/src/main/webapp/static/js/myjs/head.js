var locat = (window.location+'').split('/');
$(function(){if('main' === locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];}});

var mid = "index";	    //菜单点中状态
var fmid = "fIndex";	//父菜单点中状态
var messageCount = 0;	//站内信总数
var userId;			    //用户ID
var user = "user";		//用于即时通讯（ 当前登录用户）
var messageSound = '1';	    //站内信提示音效
var websocket;			//websocket对象
var wimadress="";		//即时聊天服务器IP和端口
var oladress="";		//在线管理和站内信服务器IP和端口

function isMenu(id,fid,name,url){
    if(id !== mid){
        $("#"+mid).removeClass();
        mid = id;
    }
    if(fid !== fmid){
        $("#"+fmid).removeClass();
        fmid = fid;
    }
    $("#"+fid).attr("class","active open");
    $("#"+id).attr("class","active");
    top.mainFrame.tabAddHandler(id,name,url);
    if(url !== "/druid/index.html"){
        loadings();
    }
}

$(function(){
    getHeadMsg();	//初始页面最顶部信息
});

//初始页面信息
function getHeadMsg(){
    $.ajax({
        type: "get",
        url: locat+'/head/getList.do?tm='+new Date().getTime(),
        data: encodeURI(""),
        dataType:'json',
        //beforeSend: validateData,
        cache: false,
        success: function(data){
            $.each(data.list, function(i, list){
                $("#user_info").html('<small>Welcome</small> '+list.name+'');//登陆者资料
                user = list.username;
                userId = list.id;		//用户ID
                if(list.username !== 'administrator'){
                    $("#systemset").hide();	//隐藏系统设置
                }
            });
            updateUserPhoto(data.userPhoto);			//用户头像
            $("#messageCount").html(Number(data.messageCount));	//站内信未读总数
            messageSound = data.messageSound;				//站内信提示音效
            wimadress = data.wimadress;				//即时聊天服务器IP和端口
            oladress = data.oladress;					//在线管理和站内信服务器IP和端口
            online();									//连接在线
        }
    });
}

//获取站内信未读总数(在站内信删除未读新信件时调用此函数更新未读数)
function getMessageCount(){
    $.ajax({
        type: "POST",
        url: locat+'/head/getMessageCount.do?tm='+new Date().getTime(),
        data: encodeURI(""),
        dataType:'json',
        cache: false,
        success: function(data){
            messageCount = Number(data.messageCount);
            $("#messageCount").html(Number(messageCount));	//站内信未读总数
        }
    });
}

//加入在线列表
function online(){
    if (window.WebSocket) {
        websocket = new WebSocket(encodeURI('ws://'+oladress)); //oladress在main.jsp页面定义
        websocket.onopen = function() {
            //连接成功
            websocket.send('[join]'+user);
        };
        websocket.onerror = function() {
            //连接失败
        };
        websocket.onclose = function() {
            //连接断开
        };
        //消息接收
        websocket.onmessage = function(message) {
            message = JSON.parse(message.data);
            if(message.type === 'goOut'){
                $("body").html("");
                goOut("1");
            }else if(message.type === 'theGoOut'){
                $("body").html("");
                goOut("2");
            }else if(message.type === 'sendMessage'){
                messageCount = Number(messageCount)+1;
                $("#messageCount").html(Number(messageCount));
                $("#messageObj").html('<audio style="display: none;" src="static/sound/'+messageSound+'.mp3" autoplay controls></audio>');
                $("#messageMsg").tips({
                    side:3,
                    msg:'有新消息',
                    bg:'#AE81FF',
                    time:30
                });
            }
        };
    }
}

//下线
function goOut(msg){
    window.location.href=locat+"/logout.do?msg="+msg;
}

//去通知收信人有站内信接收
function messageGoMsg(username){
    var usernames = username.split(';');
    for(var i=0;i<usernames.length;i++){
        websocket.send('[messageMsg]'+usernames[i]);//发送通知
    }
}

//读取站内信时减少未读总数
function readMessage(){
    messageCount = Number(messageCount)-1;
    $("#messageCount").html(Number(messageCount) <= 0 ?'0':messageCount);
}

//修改头像
function editPhoto(){
    loadings();
    var diag = new top.Dialog();
    diag.Drag=true;
    diag.Title ="修改头像";
    diag.URL = locat+'/head/editPhoto.do';
    diag.Width = 650;
    diag.Height = 530;
    diag. ShowMaxButton = true;	//最大化按钮
    diag.ShowMinButton = true;		//最小化按钮
    diag.CancelEvent = function(){ //关闭事件
        diag.close();
    };
    diag.show();
}

//修改个人资料
function editUser(){
    loadings();
    var diag = new top.Dialog();
    diag.Drag=true;
    diag.Title ="个人资料";
    diag.URL = locat+'/user/goEditMyUser.do';
    diag.Width = 469;
    diag.Height = 465;
    diag.CancelEvent = function(){ //关闭事件
        diag.close();
    };
    diag.show();
}

//系统设置
function editSys(){
    loadings();
    var diag = new top.Dialog();
    diag.Drag=true;
    diag.Title ="系统设置";
    diag.URL = locat+'/head/goSystem.do';
    diag.Width = 600;
    diag.Height = 526;
    diag.CancelEvent = function(){ //关闭事件
        diag.close();
    };
    diag.show();
}

//站内信
function messageMsg(){
    loadings();
    var diag = new top.Dialog();
    diag.Drag=true;
    diag.Title ="站内信";
    diag.URL = locat+'/online/list.do?status=2';
    diag.Width = 800;
    diag.Height = 500;
    diag.CancelEvent = function(){ //关闭事件
        diag.close();
    };
    diag.show();
}

//切换菜单
function changeMenus(){
    window.location.href=locat+'/main/yes';
}

//清除加载进度
function hides(){
    $("#loadings").hide();
}

//显示加载进度
function loadings(){
    $("#loadings").show();
}

//刷新用户头像
function updateUserPhoto(value){
    $("#userPhoto").attr("src",value);//用户头像
}
