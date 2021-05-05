let index = {
	init:function(){
		
			$("#btnJoin").on("click",()=>{
				this.join();
			});
			
//			$("#btnLogin").on("click",()=>{
//				this.login();
//			});
			
	},
	
	join:function(){
		
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
					
			//debugger;
			//console.log(data);
			
			// ajax 통신을 이용하여 3개의 데이터를 json으로 변경하여 insert 요청
			$.ajax({
				type:"POST",
//				url:"/api/user/join",
                url:"/auth/joinProc",
				data:JSON.stringify(data),
				contentType:"application/json;charset=utf-8",
				dataType:"json" 
				  
			}).done(function(resp){
				//debugger;
				alert("회원가입이 완료되었습니다.");
				location.href = "/"
			}).fail(function(){
				//debugger;
				alert(JSON.stringify(error));
				
			});	
			
			//debugger;
			//console.log(data);		
	}
	//,
	
/*		login:function(){
		
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
		}
					
			//debugger;
			//console.log(data);
			
			$.ajax({
				type:"POST",
				url:"/api/user/login",
				data:JSON.stringify(data),
				contentType:"application/json;charset=utf-8",
				dataType:"json" 
				  
			}).done(function(resp){
				//debugger;
				alert("로그인 완료되었습니다.");
				location.href = "/"
			}).fail(function(){
				//debugger;
				alert(JSON.stringify(error));
				
			});	
			
			//debugger;
			//console.log(data);		
	} */
}

index.init();