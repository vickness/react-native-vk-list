import React from 'react';
import { TouchableOpacity, Text, View } from 'react-native';
import FastImage from "react-native-fast-image";

const TableViewRow = props => {
    return (
        <TouchableOpacity style={{flex: 1, padding: 10}}>
            <View style={{flexDirection: 'row'}}>
                <FastImage
                    style={{width: 30, height: 30, marginRight: 10}}
                    source={{uri: 'http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg'}}
                />
                <Text>{`row=${props.row}, data=${props.data}`}</Text>
            </View>
            <View style={{marginVertical: 10}}>
                <Text>{"我们要学会感谢别人的懒惰，因为正是他们的懒惰，才使我们拥有了更多做事的机会，为我们搭起了展示才华的舞台与通向成功之路的台阶"}</Text>
            </View>
            <View style={{flexDirection: 'row'}}>
                <FastImage
                    style={{width: 60, height: 60, margin: 10}}
                    source={{uri: 'http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg'}}
                />
                <FastImage
                    style={{width: 60, height: 60, margin: 10}}
                    source={{uri: 'http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg'}}
                />
                <FastImage
                    style={{width: 60, height: 60, margin: 10}}
                    source={{uri: 'http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg'}}
                />
                <FastImage
                    style={{width: 60, height: 60, margin: 10}}
                    source={{uri: 'http://c.hiphotos.baidu.com/image/pic/item/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg'}}
                />
            </View>
        </TouchableOpacity>
    );
};

export default TableViewRow;
