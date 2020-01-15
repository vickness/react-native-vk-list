import React from 'react';
import { Text, View } from 'react-native';
import FastImage from "react-native-fast-image";

const TableViewFooter = props => {
    return (
        <View>
            <FastImage
                style={{height: 180}}
                source={{uri: 'http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg'}}
            />
            {
                console.log(props)
            }
        </View>
    );
};

export default TableViewFooter;
