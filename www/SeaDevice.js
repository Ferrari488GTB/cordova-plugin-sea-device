var exec = require('cordova/exec');

var SeaDevice = function(){
	
};

SeaDevice.prototype.exitApp = function(arg0,success,error){
	exec(success,error,"SeaDevice","exitApp",[arg0]);
}

SeaDevice.prototype.call = function(arg0,success,error){
	exec(success,error,"SeaDevice","call",[arg0]);
}

module.exports = new SeaDevice();