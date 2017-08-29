function userRegist(){
	//清除提示信息
	$("#warning_1").hide();
	//获取参数
	var name = $("#regist_username").val().trim();
	var nick = $("#nickname").val().trim();
	var regist_password = $("#regist_password").val().trim();
	var final_password = $("#final_password").val().trim();

	var ok = true;
	//检查数据格式
	//检查用户数据
	if(name == ""){
		ok = false;
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
	}
	//检测密码：1.非空 2 不能小于6位
	//检测确认密码：是否一致
	if(regist_password == ""){
		ok = false;
		$("#warning_2 span").html("密码不能为空");
		$("#warning_2").show();
	}else if(regist_password.length>0 
			&& regist_password.length<6){
		ok = false;
		$("#warning_2 span").html("密码不能小于6位");
		$("#warning_2").show();
	}
	if(regist_password !=final_password){
		ok = false;
		$("#warning_3 span").html("输入密码不一致");
		$("#warning_3").show();
	}
	
	if(ok){//通过数据校验通过
		//发送ajax请求
		$.ajax({
			url:path+"/user/add.do",
			type:"post",
			data:{"name":name,
				  "nick":nick,
				  "password":regist_password},
			dataType:"json",//返回数据格式
			success:function(result){
				if(result.status==0){
					$("#back").click();//触发返回按钮单击
				}else if(result.status == 1){
					$('#warning_1 span').html(result.msg); 
					$('#warning_1').show();//显示提示信息div
				}	
			},
			error:function(){
				alert("注册失败啦！");
			}
		});
		
	}

}