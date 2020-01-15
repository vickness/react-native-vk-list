//
//  RNTableViewCell.m
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <React/RCTRootView.h>
#import "RNTableViewCell.h"

@implementation RNTableViewCell {
    RCTRootView *_rootView;
}

- (instancetype)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier bridge:(RCTBridge *)bridge reactModule:(NSString *)reactModule indePath:(NSIndexPath *)indexPath data:(id)data {
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        NSDictionary *props = [self getProps:data indexPath:indexPath];
        _rootView = [[RCTRootView alloc] initWithBridge:bridge moduleName:reactModule initialProperties:props];
        _rootView.frame = self.contentView.frame;
        _rootView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        [self.contentView addSubview:_rootView];
        self.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    return self;
}

- (void)setData:(id)data indexPath:(NSIndexPath *)indexPath {
    NSDictionary *props = [self getProps:data indexPath:indexPath];
    _rootView.appProperties = props;
}

- (NSDictionary *)getProps:(id)data indexPath:(NSIndexPath *)indexPath {
    return @{
             @"data":data,
             @"section":[[NSNumber alloc] initWithLong:indexPath.section],
             @"row":[[NSNumber alloc] initWithLong:indexPath.row]
             };
}



@end
