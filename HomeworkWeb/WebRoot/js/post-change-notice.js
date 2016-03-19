angular.module('app', [])
	.controller('car',  function($scope){
		$("#button").click(function(scope){
			
			var notice = $("#new_notice").val();
			var classId = $("#classId").val();
			var data = "notice="+notice+"&classId="+classId;
			
			$.ajax({
	      		type: "POST",
	      		url: "changeNotice.action",
	      		data: data,
	      		success: function(msg){
	        		//$(this).parent().parent().parent().parent().find('p').html(grade);
	      			alert('公告修改成功');
	      			$("#notice").html(notice);
	   			}
	   		});  			
		});
	});