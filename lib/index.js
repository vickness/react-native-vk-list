import React from 'react';
import { requireNativeComponent } from 'react-native';
import PropTypes from 'prop-types';

const RNTableView = requireNativeComponent('RNTableView');

class TableView extends React.PureComponent {

    render() {
        return (
            <RNTableView {...this.props}/>
        )
    }
}

TableView.defaultProps = {
    rowHeight: 44,
    rowData: [],
    rowModule: ''
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
};

export default TableView;
