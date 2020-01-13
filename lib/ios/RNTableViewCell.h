//
//  RNTableViewCell.h
//  RNNetInfo
//
//  Created by Weike on 2020/1/9.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface RNTableViewCell : UITableViewCell

- (instancetype)initWithStyle:(UITableViewCellStyle)style
              reuseIdentifier:(NSString *)reuseIdentifier
                       bridge:(RCTBridge *)bridge
                  reactModule:(NSString *)reactModule;

- (void)setData:(id)data indexPath:(NSIndexPath *)indexPath;

@end
