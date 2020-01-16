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
#import <React/RCTRootView.h>
#import "MJRefresh.h"

@interface RNTableView () <UITableViewDelegate, UITableViewDataSource>

@property (nonatomic, strong) RCTRootView *headerView;
@property (nonatomic, strong) RCTRootView *footerView;
@property (nonatomic, strong) RCTBridge *bridge;
@property (nonatomic, strong) RCTEventDispatcher *eventDispatcher;

@end

@implementation RNTableView

RCT_NOT_IMPLEMENTED(-initWithFrame:(CGRect)frame)
RCT_NOT_IMPLEMENTED(-initWithFrame:(CGRect)frame style:(UITableViewStyle)style)
RCT_NOT_IMPLEMENTED(-initWithCoder:(NSCoder *)aDecoder)

#pragma mark - init
- (instancetype)initWithBridge:(RCTBridge *)bridge {
    RCTAssertParam(bridge);
    RCTAssertParam(bridge.eventDispatcher);
    self = [super initWithFrame:CGRectZero style:UITableViewStylePlain];
    if (self) {
        _eventDispatcher = bridge.eventDispatcher;
        _bridge = bridge;
        [self commonInit];
    }
    return self;
}

- (void)commonInit {
    self.separatorStyle = UITableViewCellSeparatorStyleNone;
    self.sectionFooterHeight = 0;
    self.sectionHeaderHeight = 0;
    self.tableFooterView = [UIView new];
    self.dataSource = self;
    self.delegate = self;
}


#pragma mark - Header/Footer
- (void)setHeaderModule:(NSString *)headerModule {
    _headerModule = headerModule;
    self.tableHeaderView = self.headerView;
}

- (void)setFooterModule:(NSString *)footerModule {
    _footerModule = footerModule;
    self.tableFooterView = self.footerView;
}

- (void)setHeaderHeight:(CGFloat)headerHeight {
    _headerHeight = headerHeight;
    CGRect frame = self.tableHeaderView.frame;
    frame.size.height = headerHeight;
    self.tableHeaderView.frame = frame;
}

- (void)setFooterHeight:(CGFloat)footerHeight {
    _footerHeight = footerHeight;
    CGRect frame = self.tableFooterView.frame;
    frame.size.height = footerHeight;
    self.tableFooterView.frame = frame;
}

- (void)setHeaderData:(NSDictionary *)headerData {
    _headerData = headerData;
    dispatch_async(dispatch_get_main_queue(), ^{
        self.headerView.appProperties = @{@"data": headerData};
    });
}

- (void)setFooterData:(NSDictionary *)footerData {
    _footerData = footerData;
    dispatch_async(dispatch_get_main_queue(), ^{
        self.footerView.appProperties = @{@"data": footerData};
    });
}

- (RCTRootView *)headerView {
    if (!_headerView) {
        _headerView = [[RCTRootView alloc] initWithBridge:_bridge moduleName:_headerModule initialProperties:nil];
        _headerView.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    }
    return _headerView;
}

- (RCTRootView *)footerView {
    if (!_footerView) {
        _footerView = [[RCTRootView alloc] initWithBridge:_bridge moduleName:_footerModule initialProperties:nil];
        _footerView.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    }
    return _footerView;
}


#pragma mark - UITableViewDataSource
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.rowData.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    RNTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:self.rowModule];
    id item = self.rowData[indexPath.row];
    if (cell == nil) {
        cell = [[RNTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:self.rowModule bridge:self.bridge reactModule:self.rowModule indePath:indexPath data:item];
    } else {
        [cell setData:item indexPath:indexPath];
    }
    return cell;
}


#pragma mark - refresh
- (void)setOnHeaderRefresh:(RCTDirectEventBlock)onHeaderRefresh {
    _onHeaderRefresh = onHeaderRefresh;
    self.mj_header = [MJRefreshNormalHeader headerWithRefreshingTarget:self refreshingAction:@selector(headerRefreshing)];
}

- (void)setOnFooterRefresh:(RCTDirectEventBlock)onFooterRefresh {
    _onFooterRefresh = onFooterRefresh;
    self.mj_footer = [MJRefreshBackNormalFooter footerWithRefreshingTarget:self refreshingAction:@selector(footerRefreshing)];
}

- (void)headerRefreshing {
    self.onHeaderRefresh(@{});
}

- (void)footerRefreshing {
    self.onFooterRefresh(@{});
}

- (void)startHeaderRefresh {
    [self.mj_header beginRefreshing];
}

- (void)stopHeaderRefresh {
    [self.mj_header endRefreshing];
}

- (void)startFooterRefresh {
    [self.mj_footer beginRefreshing];
}

- (void)stopFooterRefresh {
    [self.mj_footer endRefreshing];
}

- (void)stopFooterRefreshWithNoData {
    [self.mj_footer endRefreshingWithNoMoreData];
}

@end
