import React from 'react';
import { Text, View } from 'react-native';
import FastImage from "react-native-fast-image";

const TableViewHeader = props => {
    return (
        <View>
            <FastImage
                style={{height: 280}}
                source={{uri: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg'}}
            />
            <Text>{props.text}</Text>
        </View>
    );
};

export default TableViewHeader;
