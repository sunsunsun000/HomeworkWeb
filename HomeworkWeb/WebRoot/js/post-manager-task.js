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
						var classId = $("#classId").val();
						var data = "taskName=" + name
								+ "&description=" + description
								+ "&year=" + year
								+ "&month=" + month
								+ "&day=" + day
								+ "&hour=" + hour
								+ "&classId=" + classId;
						$.ajax({
							type : "POST",
							url : "addTask.action",
							data : data,
							success : function(msg) {
								// $(this).parent().parent().parent().parent().find('p').html(grade);
								alert('添加成功');
								location.reload(true);
							},
							error: function(){ //失败
							alert('添加失败，请检查提交的内容');
							}, 
						});

					});
		});