//
//  RNTableViewManager.m
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import "RNTableViewManager.h"
#import "RNTableView.h"
#import <React/RCTBridge.h>
#import <React/RCTUIManager.h>

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

RCT_EXPORT_VIEW_PROPERTY(onHeaderRefresh, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onFooterRefresh, RCTDirectEventBlock)

RCT_EXPORT_MODULE(RNTableView)
- (UIView *)view{
    return [[RNTableView alloc] initWithBridge:self.bridge];
}

+ (BOOL)requiresMainQueueSetup{
    return YES;
}

RCT_EXPORT_METHOD(startHeaderRefresh:(nonnull NSNumber *)reactTag) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNTableView *view = (RNTableView *) viewRegistry[reactTag];
        [view startHeaderRefresh];
    }];
}

RCT_EXPORT_METHOD(stopHeaderRefresh:(nonnull NSNumber *)reactTag) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNTableView *view = (RNTableView *) viewRegistry[reactTag];
        [view stopHeaderRefresh];
    }];
}

RCT_EXPORT_METHOD(startFooterRefresh:(nonnull NSNumber *)reactTag) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNTableView *view = (RNTableView *) viewRegistry[reactTag];
        [view startFooterRefresh];
    }];
}

RCT_EXPORT_METHOD(stopFooterRefresh:(nonnull NSNumber *)reactTag) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNTableView *view = (RNTableView *) viewRegistry[reactTag];
        [view stopFooterRefresh];
    }];
}

RCT_EXPORT_METHOD(stopFooterRefreshWithNoData:(nonnull NSNumber *)reactTag) {
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        RNTableView *view = (RNTableView *) viewRegistry[reactTag];
        [view stopFooterRefreshWithNoData];
    }];
}

@end
