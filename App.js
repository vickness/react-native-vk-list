/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, SafeAreaView, View} from 'react-native';
import TableView from './lib/index';

export default class App extends Component {

    constructor(props) {
        super(props);

        this.data = [];
        for (let i=0; i< 100; i++) {
            this.data.push({
                name: 'aaa',
                age: i
            });
        }
    }

  render() {
    return (
        <SafeAreaView style={{flex: 1}}>
            <TableView
                rowHeight={200}
                cellName={"TableViewExampleCell"}
                dataSource={this.data}
            />
        </SafeAreaView>
    );
  }
}
