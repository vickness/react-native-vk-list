//
//  RNTableView.m
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import "RNTableView.h"
#import "RNTableViewCell.h"
#import <React/RCTConvert.h>
#import <React/RCTEventDispatcher.h>

@interface RNTableView () <UITableViewDelegate, UITableViewDataSource>

@end

@implementation RNTableView {
    RCTBridge *_bridge;
    RCTEventDispatcher *_eventDispatcher;
}

RCT_NOT_IMPLEMENTED(-initWithFrame:(CGRect)frame)
RCT_NOT_IMPLEMENTED(-initWithFrame:(CGRect)frame style:(UITableViewStyle)style)
RCT_NOT_IMPLEMENTED(-initWithCoder:(NSCoder *)aDecoder)

#pragma mark - init
- (instancetype)initWithBridge:(RCTBridge *)bridge {
    RCTAssertParam(bridge);
    RCTAssertParam(bridge.eventDispatcher);
    if ((self = [super initWithFrame:CGRectZero style:UITableViewStylePlain])) {
        _eventDispatcher = bridge.eventDispatcher;
        _bridge = bridge;
        while ([_bridge respondsToSelector:NSSelectorFromString(@"parentBridge")]
               && [_bridge valueForKey:@"parentBridge"]) {
            _bridge = [_bridge valueForKey:@"parentBridge"];
        }
        [self commonInit];
    }
    return self;
}

- (void)commonInit {
    self.separatorStyle = UITableViewCellSeparatorStyleNone;
    self.backgroundColor = [UIColor whiteColor];
    self.sectionFooterHeight = 0;
    self.sectionHeaderHeight = 0;
    self.tableFooterView = [UIView new];
    self.dataSource = self;
    self.delegate = self;
}

#pragma mark - UITableViewDataSource
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.data.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    RNTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:self.identifier];
    if (cell == nil) {
        cell = [[RNTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:self.identifier bridge:_bridge reactModule:self.identifier];
    }
    id item = self.data[indexPath.row];
    [cell setData:item indexPath:indexPath];
    return cell;
}

@end
