import React from 'react';
import { requireNativeComponent, UIManager, findNodeHandle } from 'react-native';
import PropTypes from 'prop-types';

const RNTableView = requireNativeComponent('RNTableView');

class TableView extends React.PureComponent {

    render() {
        const {onHeaderRefresh, onFooterRefresh, ...other} = this.props;
        return (
            <RNTableView
                {...other}
                enableHeaderRefresh={!!onHeaderRefresh}
                enableFooterRefresh={!!onFooterRefresh}
                onHeaderRefresh={onHeaderRefresh}
                onFooterRefresh={onFooterRefresh}
            />
        )
    }

    startHeaderRefresh = () => {
        this._sendCommand("startHeaderRefresh");
    };

    stopHeaderRefresh = () => {
        this._sendCommand("stopHeaderRefresh");
    };

    startFooterRefresh = () => {
        this._sendCommand("startFooterRefresh");
    };

    stopFooterRefresh = () => {
        this._sendCommand("stopFooterRefresh");
    };

    stopFooterRefreshWithNoData = () => {
        this._sendCommand("stopFooterRefreshWithNoData");
    };

    _sendCommand(command, params) {
        UIManager.dispatchViewManagerCommand(
            findNodeHandle(this),
            UIManager.getViewManagerConfig("RNTableView").Commands[command],
            params);
    }
}

TableView.defaultProps = {
    rowHeight: 44,
    rowData: [],
    rowModule: '',
    showSeparator: true
};

TableView.propTypes = {

    rowModule: PropTypes.string,
    rowHeight: PropTypes.number,
    rowData: PropTypes.array,

    headerModule: PropTypes.string,
    headerHeight: PropTypes.number,
    headerData: PropTypes.object,

    footerModule: PropTypes.string,
    footerHeight: PropTypes.number,
    footerData: PropTypes.object,

    onHeaderRefresh: PropTypes.func,
    onFooterRefresh: PropTypes.func,

    showSeparator: PropTypes.bool
};

export default TableView;
