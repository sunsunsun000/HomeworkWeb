angular.module('app', [])
        .controller('car',  function($scope){
                $(".post").click(function(scope){
                        var grade=$(this).parent().parent().find('#grade').val();
                        //var grade = $("#grade").val();
                        //var homeworkId = $("#homeworkId").val();
                        var homeworkId = $(this).parent().parent().find('#homeworkId').val();
                        var data = "grade="+grade+"&homeworkId="+homeworkId;
                        $.ajax({
                        type: "POST",
                        url: "correctTask.action",
                        data: data,
                        success: function(msg){
                                //$(this).parent().parent().parent().parent().find('#showGrade').html(grade);
                                $("#showGrade_"+homeworkId).html(grade);
                                }
                        });
                });
        });
