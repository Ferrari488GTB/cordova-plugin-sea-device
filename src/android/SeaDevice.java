package com.sea.plugins;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

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
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+telephoneNumber));
            cordova.getActivity().startActivity(intent);
            JSONObject result = new JSONObject();
            try {
                result.put("code",'1');
                result.put("msg","正在通话");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callbackContext.success(result);
        }else{
            callbackContext.error("电话号码不能为空");
        }
    }
    
}
