alert("asdafasd");
$.ajax({
url:"driver/saveDriverComments",//注意在这里的请求路径上面不能加上/否则就会出现400错误，无法找到请求路径
type:"POST",
contentType: "application/json",//不加此项就会出现415错误代码
dataType:"JSON",
data:JSON.stringify({"driverId":"2","phone":"15195900075","comment":"好","starLevel","2"}),
success:function(data,status){alert("ok");},
error:function(e){alert(e);},
fail:function(){alert("fail");}
});