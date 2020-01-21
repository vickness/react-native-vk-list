//
//  RNTableView.h
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <React/RCTComponent.h>

@class RCTBridge;

@interface RNTableView : UITableView

@property (nonatomic, copy) NSArray *rowData;
@property (nonatomic, copy) NSString *rowModule;

@property (nonatomic, copy) NSString *headerModule;
@property (nonatomic, assign) CGFloat headerHeight;
@property (nonatomic, copy) NSDictionary *headerData;

@property (nonatomic, copy) NSString *footerModule;
@property (nonatomic, assign) CGFloat footerHeight;
@property (nonatomic, copy) NSDictionary *footerData;

@property (nonatomic, copy) RCTDirectEventBlock onHeaderRefresh;
@property (nonatomic, copy) RCTDirectEventBlock onFooterRefresh;

@property (nonatomic, assign) BOOL showSeparator;

- (instancetype)initWithBridge:(RCTBridge *)bridge;

- (void)startHeaderRefresh;

- (void)stopHeaderRefresh;

- (void)startFooterRefresh;

- (void)stopFooterRefresh;

- (void)stopFooterRefreshWithNoData;

@end

