# SeaDevice：提供基本的设备操作。
## 简介
   这个插件定义了一个全局对象cordova.plugins.seaDevice，可以用来进行设备的基本操作。尽管这个对象在全局作用域中，但直到deviceready事件触发后，这个对象才能使用。
```javascript
document.addEventListener("deviceready", onDeviceReady, false);
function onDeviceReady() {
    	console.log(cordova.plugins.seaDevice);
}
```
## 安装方法
```javascript
cordova plugin add cordova-plugin-sea-device
```
## 支持平台
* Android
* iOS

## 退出app
```javascript
cordova.plugins.seaDevice.exitApp();
```
## 打电话
	Android 6.0及以上提供动态打开通话权限功能。
```javascript
if(cordova.plugins.seaDevice){
    cordova.plugins.seaDevice.call(
        "18812345678",
        function(data){
            // 成功 
        },
        function(errorMsg){
            // 失败
        }
    );
}else{
    alert("设备未就绪");
}
```
## 联系作者
shatanhaifeng@163.com

