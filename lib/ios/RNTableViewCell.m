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

- (instancetype)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier bridge:(RCTBridge *)bridge reactModule:(NSString *)reactModule {
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        _rootView = [[RCTRootView alloc] initWithBridge:bridge moduleName:reactModule initialProperties:nil];
        _rootView.frame = self.contentView.frame;
        _rootView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        [self.contentView addSubview:_rootView];
        self.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    return self;
}

- (void)setData:(id)data indexPath:(NSIndexPath *)indexPath {
    NSDictionary *props = @{
                            @"data":data,
                            @"section":[[NSNumber alloc] initWithLong:indexPath.section],
                            @"row":[[NSNumber alloc] initWithLong:indexPath.row]
                            };
    _rootView.appProperties = props;
}



@end
