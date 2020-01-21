# react-native-vk-list

高性能原生列表，iOS端使用 TableView，Android端使用 ListView  
集成下拉刷新和上拉加载，iOS使用 MJRefresh，Android端使用 SmartRefreshLayout

## 安装
只支持 react-native >= 0.60 (autolinking)
```bash
yarn add react-native-vk-list  
cd ios
pod install
```

## 使用
```js
const TableViewHeader = props => {
    return (
        <View>
        </View>
    );
};
AppRegistry.registerComponent('TableViewHeader', () => TableViewHeader);
```

```js
const TableViewFooter = props => {
    return (
        <View>
        </View>
    );
};
AppRegistry.registerComponent('TableViewFooter', () => TableViewFooter);
```

```js
const TableViewRow = props => {
    return (
        <View>
        </View>
    );
};
AppRegistry.registerComponent('TableViewRow', () => TableViewRow);
```

```js
<TableView
    style={{flex: 1}}
    ref={o => this.tableView = o}

    rowModule={"TableViewRow"}
    rowHeight={200}
    rowData={this.state.rowData}

    headerModule={"TableViewHeader"}
    headerHeight={150}
    headerData={this.state.headerData}

    footerModule={"TableViewFooter"}
    footerHeight={60}
    footerData={this.state.footerData}

    onHeaderRefresh={this._onHeaderRefresh}
    onFooterRefresh={this._onFooterRefresh}

    showSeparator={false}
/>

```

```js
this.tableView.startHeaderRefresh();

this.tableView.stopHeaderRefresh();

this.tableView.startFooterRefresh();

this.tableView.stopFooterRefresh();

this.tableView.stopFooterRefreshWithNoData();
```

