/********* SeaDevice.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "SeaDevice.h"

@implementation SeaDevice

- (void)exitApp:(CDVInvokedUrlCommand *)command{
    exit(0);
}

@end
