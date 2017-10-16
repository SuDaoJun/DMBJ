//大轮播图
(function(){
	var list = document.getElementById("list");
	var imgs = list.children;
	var graphs = document.getElementById("graphs");
	var lis =graphs.children[0].children;
	var timer = null;
	var current = 0;
	var index= 0;
	function animate(obj,target){
		clearInterval(obj.timer);
		var speed = obj.offsetLeft < target? 50:-50;
		obj.timer = setInterval(function(){
			var result = target - obj.offsetLeft;
			obj.style.left = obj.offsetLeft + speed + "px";
			if(Math.abs(result) <= 50){
				clearInterval(obj.timer);
				obj.style.left = target + "px";
			}
		},10);
	}
	function autoplay(){
		current++;
		if(current > imgs.length-1){
			list.style.left = 0;
			current = 1;
		}
		animate(list,current*(-1660));
		index++;
		if(index > lis.length - 1){
			index = 0;
		}
		for (var i = 0; i < lis.length; i++) {
			lis[i].className = "";
		}
		lis[index].className = "active";
	}		
	timer = setInterval(autoplay,4000);
	show();
	function show(){
		for (var i = 0; i < lis.length; i++) {
			lis[i].index = i;
			lis[i].onclick = function(){
				animate(list,this.index*(-1660));
				for (var i = 0; i < lis.length; i++) {
					lis[i].className = "";
				}
				this.className = "active";
				index = current = this.index;
			}
		}
	}
})();
//小轮播图
(function(){
	var bigList = document.getElementById("bigList");
	var bigImgs = bigList.children;
	var bigGraphs = document.getElementById("bigGraphs");
	var bigLis =bigGraphs.children;
	var timer = null;
	var current = 0;
	var index= 0;
	function animate(obj,target){
		clearInterval(obj.timer);
		var speed = obj.offsetLeft < target? 50:-50;
		obj.timer = setInterval(function(){
			var result = target - obj.offsetLeft;
			obj.style.left = obj.offsetLeft + speed + "px";
			if(Math.abs(result) <= 50){
				clearInterval(obj.timer);
				obj.style.left = target + "px";
			}
		},10);
	}
	function play(){
		current++;
		if(current > bigImgs.length-1){
			bigList.style.left = 0;
			current = 1;
		}
		animate(bigList,current*(-613));
		index++;
		if(index > bigLis.length - 1){
			index = 0;
		}
		for (var i = 0; i < bigLis.length; i++) {
			bigLis[i].className = "";
		}
		bigLis[index].className = "active";
	}		
	timer = setInterval(play,4000);
	showImg();
	function showImg(){
		for (var i = 0; i < bigLis.length; i++) {
			bigLis[i].index = i;
			bigLis[i].onclick = function(){
				animate(bigList,this.index*(-613));
				for (var i = 0; i < bigLis.length; i++) {
					bigLis[i].className = "";
				}
				this.className = "active";
				index = current = this.index;
			}
		}
	}
})();


//tab切换
function shows(obj,objs,name){
		for (var i = 0; i < obj.length; i++) {
			obj[i].index = i;
			obj[i].onmouseenter = function(){
				for (var j = 0; j < obj.length; j++) {
					obj[j].firstChild.className = "";
				}
				this.firstChild.className = "active";
				for (var i = 0; i < objs.length; i++) {
					objs[i].className = name;
				}
				objs[this.index].className = name+" show";
			}
		}
	}
(function(){
	var hot = document.getElementById("hot");
	var hots = hot.children[0].children;
	var news = document.getElementById("news").children;
	shows(hots,news);
})();

(function(){
	var weal = document.getElementById("weal");
	var weals = weal.children[0].children;
	var gifts = document.getElementById("gift").children;
	shows(weals,gifts,"bottom-gift");
})();

(function(){
	var guide = document.getElementById("guide");
	var guides = guide.children[0].children;
	var details = document.getElementById("detail").children;
	shows(guides,details,"detail-txt");
})();

(function(){
	var differ = document.getElementById("differ");
	var differs = differ.children[0].children;
	var pLists = document.getElementById("pList").children;
	shows(differs,pLists,"person-list");
	var prev = document.getElementById("prev");
	var next = document.getElementById("next");
	var moves = document.getElementById("moves");
	var timer =null;
	next.addEventListener("click",rMove);		
	prev.addEventListener("click",lMove);		
	function rMove(){
		clearInterval(timer);
		var speed = -5;
		var num = 0;
		timer = setInterval(function(){
			moves.style.left = moves.offsetLeft + speed + "px";
			num++;
			if(moves.offsetLeft <= -455){
				moves.style.left = -455 +"px";
			}
			if(num >= 13){
				clearInterval(timer);
			}
		},30);
	}
	function lMove(){
		clearInterval(timer);
		var speed = 5;
		var num = 0;
		timer = setInterval(function(){
			moves.style.left = moves.offsetLeft + speed + "px";
			num++;
			if(moves.offsetLeft >= 0){
				moves.style.left = 0;
			}
			if(num >= 13){
				clearInterval(timer);
			}
		},30);
	}
})();

(function(){
	var paly = document.getElementById("play");
	var plays = play.children[1].children;
	var researchs = document.getElementById("research").children;
	shows(plays,researchs);
})();

(function(){
	var listMove = document.getElementById("listMove");
	var mLeft = document.getElementById("mLeft");
	var mRight = document.getElementById("mRight");
	mRight.addEventListener("mouseenter", function(){animate(listMove,-910)});
	mRight.addEventListener("mouseleave", function(){clearInterval(listMove.timer)});
	mLeft.addEventListener("mouseenter", function(){animate(listMove,0)});
	mLeft.addEventListener("mouseleave", function(){clearInterval(listMove.timer)});
	function animate(obj,target){
		clearInterval(obj.timer);
		var speed = obj.offsetLeft < target? 3:-3;
		obj.timer = setInterval(function(){
			var result = target - obj.offsetLeft;
			obj.style.left = obj.offsetLeft + speed + "px";
			if(Math.abs(result) <= 3){
				clearInterval(obj.timer);
				obj.style.left = target + "px";
			}
		},15);
	}
})();

(function(){
	var more = document.getElementById("more");
	var link = document.getElementById("link");
	more.addEventListener("click", change);
	function change(){
		link.style.height = "130px";
	}
})();



// 注册显隐
// (function(){
 var login = document.getElementById("login");
 var login2 = document.getElementById("login2");
 var showLogin = document.getElementById("show_login");
 var loginClose = document.getElementById("login_close");
 function show(){
 	showLogin.style.display = "block";
 	document.body.style.overflow = "hidden"; 
 }
 function hidden(){
 	showLogin.style.display = "none";
 	document.body.style.overflow = "visible";
 	valueHidden(loginTxt,loginTxt2,loginTxt3); 
 }
 login.addEventListener("click", show);
 login2.addEventListener("click", show);
 loginClose.addEventListener("click", hidden); 
//与后台传递数据

	var loginBtn = document.getElementById("login_btn");
	var loginTxt = document.getElementById("login_txt");
	var loginTxt2 = document.getElementById("login_txt2");
	var loginTxt3 = document.getElementById("login_txt3");
	var user =document.getElementById("user");
	var password =document.getElementById("password");
	var enter = document.getElementById("enter");
	var enroll = document.getElementById("enroll");
	var url="http://192.168.1.22:8088/DMBJ/"; 
	function ajaxGet(url,data,callback){
		var xhr = new XMLHttpRequest();

		xhr.open("GET",url+"?"+data,true);
		xhr.send();
		xhr.onreadystatechange=function(){
			if(xhr.status == 200 && xhr.readyState == 4){
				var result=xhr.responseText;
				if(callback){
					callback(result);
				}
			}
		};
	}
	// 注册用户
	loginBtn.onclick=function(){
		var loginUser = loginTxt.value;
		var loginPassword = loginTxt2.value;
		var loginPasswords = loginTxt3.value;
		var id = new Date().getTime();
		if(loginPassword != ""){
			if(loginPassword != loginPasswords){
				loginTxt3.setAttribute("placeholder","密码不一致，请重新输入");
				loginTxt3.value = "";
			}else{			
				addUser(id,loginUser,loginPassword);
				enter.innerHTML =  loginUser;
				login.innerHTML = "欢迎你";
				valueHidden(loginTxt,loginTxt2,loginTxt3);
				hidden();
			}
		}
	};
	function valueHidden(user,password,passwords){
		user.value = "";
		password.value = "";
		passwords.value = "";
	}
	function addUser(id,loginUser,loginPassword){
		var urlAdd = url+"add";
		var data = "id="+id+"&username="+loginUser+"&password="+loginPassword;
		ajaxGet(urlAdd,data,function(result){
			if(result==1){
				alert("注册成功");
			}else{
				alert("注册失败");
			}
		});		
	}
	// 登录判断
	enroll.onclick=function(){		 
		var userTxt = user.value;
		var passwordTxt = password.value;
		selectUser(userTxt,passwordTxt);
		
	}
	function selectUser(username,passwords){
		var urlSelect = url + "select";
		var data = "username="+username+"&password="+passwords;
		ajaxGet(urlSelect,data,function(result){			 
			if(result==1){
				alert("登陆成功");
				enter.innerHTML =  username;
				login.innerHTML = "欢迎你";
				valueHidden(user,password,"");
			}else{
				alert("登陆失败，用户名或密码错误");
				valueHidden(user,password,"");

			}
		})
	}
	var textArea = document.getElementById("textArea");
	var sendTxt = document.getElementById("sendTxt");
	var commentList = document.getElementById("comment_list");
	// 发送留言
	sendTxt.onclick = function(){
		if(enter.innerHTML != "登录"){
			var username = enter.innerHTML;
			var content = textArea.value;
			var date = getDate();
			var id = new Date().getTime();
			creatDl(id,username,date,content);
			addContent(id,username,date,content);
			textArea.value ="";

		}else{
			alert("请先注册或登录");
			textArea.value ="";
		}
		
	}
	function addContent(id,username,date,content){
		var urlAdd = url+"add";
		var data = "id="+id+"&username="+username+"&date="+date+"&content="+content;
		ajaxGet(urlAdd,data,function(result){
			if(result==1){
				alert("发表成功");
			}else{
				alert("发表失败");
			}
		});		
	}
	function creatDl(id,username,date,content){
		var dl = document.createElement("dl");
		dl.id = id;
		dl.innerHTML = "<dt>"+ username +"："+"</dt><dd>"+content+"</dd><i>"+date+"</i><input type='button' value='删除' onclick='deleteDl("+id+")' />" ;
		commentList.appendChild(dl);
	}
	function getDate(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		return year+"-"+month+"-"+day;
	}
	function deleteUser(id){
		var urlDelete = url + "delete";
		var data = "id=" +id;
		ajaxGet(urlDelete,data,function(result){
			if(result==1){
				alert("删除成功");
			}else{
				alert("删除失败");
			}
		});
	}

	function deleteDl(id){
		var dl = document.getElementById(id);
		commentList.removeChild(dl);
		deleteUser(id);
	}
	getAll();
	// 把已有数据库放到前端
	function getAll(){
		var urlAll = url + "all";
		ajaxGet(urlAll, "", function(result){
			//字符串转json对象
			var json = JSON.parse(result);
			if(json.code==1){
				var users = json.users;
				for(var i = 0; i < users.length; i++){
					var user = users[i];
					if(user.content != "" && user.content != undefined){
						creatDl(user.id,user.username,user.date,user.content);
					}
				}
			}else{
				alert("数据库错误");
			}
		});
	}

// })();对删除用户有影响	
