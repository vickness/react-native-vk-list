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

RCT_EXPORT_VIEW_PROPERTY(rowData, NSArray)
RCT_EXPORT_VIEW_PROPERTY(rowModule, NSString)
RCT_EXPORT_VIEW_PROPERTY(rowHeight, CGFloat)

RCT_EXPORT_VIEW_PROPERTY(headerModule, NSString)
RCT_EXPORT_VIEW_PROPERTY(headerHeight, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(headerData, NSDictionary)

RCT_EXPORT_VIEW_PROPERTY(footerModule, NSString)
RCT_EXPORT_VIEW_PROPERTY(footerHeight, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(footerData, NSDictionary)

RCT_EXPORT_MODULE(RNTableView)
- (UIView *)view{
    return [[RNTableView alloc] initWithBridge:self.bridge];
}

+ (BOOL)requiresMainQueueSetup{
    return YES;
}

@end
