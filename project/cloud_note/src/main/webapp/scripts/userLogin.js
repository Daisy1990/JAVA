function userLogin(){
	//先清除原有提示信息
    $("#count_msg").html("");
    $("#password_msg").html("");
    
	//获取请求要提交的数据
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	var ok = true;
	if(name==""){
		$("#count_msg").html("用户名不能为空");
		ok = false;
	}
	if(password == ""){
		$("#password_msg").html("密码不能为空！");
		ok = false;
	}

	//发送ajax请求
	if(ok){
		$.ajax({
			url:path+"/user/login.do",
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){//前端页面的回调处理
				//result是服务器返回的json结果
				//status msg data
				if(result.status==0){
					//登陆成功，将用户信息保存到cookie中
					
					//将身份信息写入Cookie
			 	    var token = result.data.userToken;
			 	    var userId= result.data.cn_user_id;
			 	    //(加密)写入Cookie
			 	    addCookie("userToken",token,2);
			 	    addCookie("userId",userId,2);
					window.location.href="edit.html";
				}else if(result.status == 1){
					//用户名错误
					$("#count_msg").html(result.msg);
				}else if(result.status == 2){
					//密码错误
					$("#password_msg").html(result.msg);
				}
			},
			error:function(){
				alert("登陆失败！");
			}
		});
	}
	
}