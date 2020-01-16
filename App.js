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
        for (let i=0; i< 10; i++) {
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
                ref={o => this.tableView = o}

                rowModule={"TableViewRow"}
                rowHeight={200}
                rowData={this.state.data}

                headerModule={"TableViewHeader"}
                headerHeight={300}
                headerData={{"title": "aaa"}}

                footerModule={"TableViewFooter"}
                footerHeight={200}
                footerData={{"title": "bbb"}}

                onHeaderRefresh={this._onHeaderRefresh}
                onFooterRefresh={this._onFooterRefresh}
            />
        </SafeAreaView>
    );
  }

  _onHeaderRefresh = () => {

        setTimeout(() => {
            console.log("刷新结束");
            this.tableView.stopHeaderRefresh();
        }, 2000)
  };

  _onFooterRefresh = () => {

      setTimeout(() => {
          console.log("加载结束");
          this.tableView.stopFooterRefresh();
      }, 2000)
  };

}
