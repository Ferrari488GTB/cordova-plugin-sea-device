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

