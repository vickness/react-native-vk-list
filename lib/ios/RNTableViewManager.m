//
//  RNTableViewManager.m
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import "RNTableViewManager.h"
#import "RNTableView.h"

@implementation RNTableViewManager

RCT_EXPORT_VIEW_PROPERTY(data, NSArray)
RCT_EXPORT_VIEW_PROPERTY(identifier, NSString)
RCT_EXPORT_VIEW_PROPERTY(showsVerticalScrollIndicator, BOOL)
RCT_EXPORT_VIEW_PROPERTY(rowHeight, CGFloat)

RCT_EXPORT_MODULE(RNTableView)
- (UIView *)view{
    return [[RNTableView alloc] initWithBridge:self.bridge];
}

+ (BOOL)requiresMainQueueSetup{
    return YES;
}

@end
