/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {SafeAreaView} from 'react-native';
import TableView from './lib/index';

export default class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        let data = [];
        for (let i=0; i< 1000; i++) {
            data.push({
                name: 'aaa',
                age: i
            });
        }
        this.setState({
            data: data
        });
    }

    render() {
    return (
        <SafeAreaView style={{flex: 1}}>
            <TableView
                style={{flex: 1}}

                rowModule={"TableViewRow"}
                rowHeight={200}
                rowData={this.state.data}

                headerModule={"TableViewHeader"}
                headerHeight={300}
                headerData={{"title": "aaa"}}

                footerModule={"TableViewFooter"}
                footerHeight={200}
                footerData={{"title": "bbb"}}
            />
        </SafeAreaView>
    );
  }
}
