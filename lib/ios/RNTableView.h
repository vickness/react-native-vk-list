//
//  RNTableView.h
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

@class RCTBridge;

@interface RNTableView : UITableView

@property (nonatomic, strong) NSArray *rowData;
@property (nonatomic, strong) NSString *rowModule;

@property (nonatomic, strong) NSString *headerModule;
@property (nonatomic, assign) CGFloat headerHeight;
@property (nonatomic, strong) NSDictionary *headerData;

@property (nonatomic, strong) NSString *footerModule;
@property (nonatomic, assign) CGFloat footerHeight;
@property (nonatomic, strong) NSDictionary *footerData;

- (instancetype)initWithBridge:(RCTBridge *)bridge;

@end

