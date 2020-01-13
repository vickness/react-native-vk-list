import React from 'react';
import { requireNativeComponent } from 'react-native';
import PropTypes from 'prop-types';

const RNTableView = requireNativeComponent('RNTableView');

class TableView extends React.PureComponent {

    render() {
        return (
            <RNTableView
                style={{flex: 1}}
                rowHeight={this.props.rowHeight}
                identifier={this.props.cellName}
                data={this.props.dataSource}
            />
        )
    }
}

TableView.defaultProps = {
    rowHeight: 60,
    dataSource: [],
    cellName: ''
};

TableView.propTypes = {
    dataSource: PropTypes.array,//默认数据源
    rowHeight: PropTypes.number,//高度
    cellName: PropTypes.string,//cell名称
};

export default TableView;
