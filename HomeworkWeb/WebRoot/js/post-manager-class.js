angular.module('app', []).controller(
		'car',
		function($scope) {
			$("#button").click(
					function(scope) {
						var name = $("#name").val();
						var notice = $('#notice').val();
						var data = "className=" + name
								+ "&notice=" + notice;
						$.ajax({
							type : "POST",
							url : "addClass.action",
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