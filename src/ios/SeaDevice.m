/********* SeaDevice.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "SeaDevice.h"

@implementation SeaDevice

-(void)exitApp:(CDVInvokedUrlCommand *)command{
    exit(0);
}

-(void)call:(CDVInvokedUrlCommand *)command{
    [self.commandDelegate runInBackground:^{
        CDVPluginResult *pluginResult = nil;
        NSString *telephoneNumber = [command.arguments objectAtIndex:0];
        NSURL *url = nil;
        NSMutableDictionary *dictionary = [[NSMutableDictionary alloc]init];
        if(telephoneNumber!=nil&&[telephoneNumber length]>0){
            telephoneNumber = [@"tel:" stringByAppendingString:telephoneNumber];
            url = [NSURL URLWithString:telephoneNumber];
            if([[UIApplication sharedApplication]canOpenURL:url]){
                [[UIApplication sharedApplication]openURL:url];
                [dictionary setValue:@"1" forKey:@"code"];
                [dictionary setValue:@"正在通话" forKey:@"msg"];
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:dictionary];
            }else{
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"拨打电话失败"];
            }
        }else{
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"电话号码不能为空"];
        }
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

    }];
}

@end
