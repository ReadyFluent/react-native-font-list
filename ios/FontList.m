#import "FontList.h"
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@implementation FontList

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(get:(RCTResponseSenderBlock)callback) {
    NSMutableArray *fontFamilyNames = [[NSMutableArray alloc]init];
    NSMutableArray *fontNames = [[NSMutableArray alloc]init];

    for (NSString *familyName in [UIFont familyNames]){
        [fontFamilyNames addObject:familyName];
        
        for (NSString *fontName in [UIFont fontNamesForFamilyName:familyName]) {
            [fontNames addObject:fontName];
        }
    }

    fontFamilyNames = [fontFamilyNames sortedArrayUsingSelector:@selector(compare:)];
    fontNames = [fontNames sortedArrayUsingSelector:@selector(compare:)];

    callback(@[fontFamilyNames, fontNames]);
}

@end
