/********* SeaDevice.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface SeaDevice : CDVPlugin

{
  // Member variables go here.
}

-(void)exitApp:(CDVInvokedUrlCommand *)command;

-(void)call:(CDVInvokedUrlCommand *)command;

@end
