function myFunction(){
document.getElementById("para0ne").innerHTML = "test_one 被点击了，内容需要更新";
}

function androidFunctionCall(){
var str = android.syncExec();
document.getElementById("paraTwo").innerHTML = str;
}

function showAndroidAsyncMsg(){
console.log("showAndroidAsyncMsg() is called");
android.asyncExec("来自js断的消息，经过处理后最终返回到html侧","onCallback");
}

function onCallback(msg){
document.getElementById("paraThree").innerHTML = msg;
}

function asyncFunc(){
setTimeout(function(){
android.callBack("来自js端的异步消息");
},5000);
}