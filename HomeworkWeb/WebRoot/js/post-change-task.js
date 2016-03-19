angular.module('app', []).controller(
		'car',
		function($scope) {
			$("#button").click(
					function(scope) {
						var name = $("#name").val();
						var description = $("#description").val();
						var year = $("#year").val();
						var month = $("#month").val();
						var day = $("#day").val();
						var hour = $("#hour").val();
						var taskId = $("#taskId").val();
						var data = "changeTaskModel.name=" + name
								+ "&changeTaskModel.description=" + description
								+ "&changeTaskModel.year=" + year
								+ "&changeTaskModel.month=" + month
								+ "&changeTaskModel.day=" + day
								+ "&changeTaskModel.hour=" + hour
								+ "&taskId=" + taskId;
						$.ajax({
							type : "POST",
							url : "changeTaskInfo.action",
							data : data,
							success : function(msg) {
								// $(this).parent().parent().parent().parent().find('p').html(grade);
								alert('修改成功');
								location.reload(true);
							},
							error: function(){ //失败
							alert('修改失败，请检查提交的内容');
							}, 
						});

					});
		});