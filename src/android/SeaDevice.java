package com.sea.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class SeaDevice extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("exitApp")) {
            this.exitApp();
            return true;
        }
        return false;
    }

    private void exitApp() {
        this.webView.getPluginManager().postMessage("exit",null);
    }
}
