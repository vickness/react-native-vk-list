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

    constructor() {
        super();
        this.state = {
            data: [{
                name: 'aaa',
                age: 0
            }]
        }
    }

    getItems(){
        let data = [];
        for (let i=0; i<10; i++) {
            data.push({
                name: 'aaa',
                age: i
            });
        }
        return data;
    };

    componentDidMount() {

        setTimeout(() => {
            this.setState({
                data: this.getItems()
            });
        }, 2000);
    }

    render() {
        return (
            <SafeAreaView style={{flex: 1, backgroundColor: 'white'}}>
                <TableView
                    style={{flex: 1}}
                    ref={o => this.tableView = o}

                    rowModule={"TableViewRow"}
                    rowHeight={200}
                    rowData={this.state.data}

                    // headerModule={"TableViewHeader"}
                    // headerHeight={300}
                    // headerData={{}}

                    // footerModule={"TableViewFooter"}
                    // footerHeight={200}
                    // footerData={{}}

                    onHeaderRefresh={this._onHeaderRefresh}
                    onFooterRefresh={this._onFooterRefresh}

                />
            </SafeAreaView>
        )
    }

    _onHeaderRefresh = () => {

        setTimeout(() => {
            this.setState({
                data: this.getItems()
            });
            this.tableView.stopHeaderRefresh();
        }, 2000)
    };

    _onFooterRefresh = () => {

        setTimeout(() => {
            this.setState({
                data: this.state.data.concat(this.getItems())
            });
            this.tableView.stopFooterRefresh();
        }, 2000)
    };

}
