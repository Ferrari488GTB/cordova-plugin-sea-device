package com.sea.plugins;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class SeaDevice extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("exitApp")) {
            this.exitApp();
            return true;
        }else if(action.equals("call")){
            String telephoneNumber = args.getString(0);
            this.call(telephoneNumber,callbackContext);
            return true;
        }
        return false;
    }

    private void exitApp() {
        this.webView.getPluginManager().postMessage("exit",null);
    }

    private void call(String telephoneNumber,CallbackContext callbackContext){
        if(telephoneNumber!=null&&telephoneNumber.length()>0){
            Intent intent= new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:"+telephoneNumber));
            if(PermissionHelper.hasPermission(this,"android.permission.CALL_PHONE")) {
                this.cordova.getActivity().startActivity(intent);
                JSONObject result = new JSONObject();
                try {
                    result.put("code", '1');
                    result.put("msg", "正在通话");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackContext.success(result);
            }else{
                PermissionHelper.requestPermission(this,100,"android.permission.CALL_PHONE");
            }
        }else{
            callbackContext.error("电话号码不能为空");
        }
    }
    
}
