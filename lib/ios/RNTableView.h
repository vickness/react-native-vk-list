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

@property (nonatomic, copy) NSArray *data;

@property (nonatomic, copy) NSString *identifier;

- (instancetype)initWithBridge:(RCTBridge *)bridge;

@end

