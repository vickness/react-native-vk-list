/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import TableViewRow from "./src/TableViewRow";
import TableViewHeader from "./src/TableViewHeader";
import TableViewFooter from "./src/TableViewFooter";

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent('TableViewRow', () => TableViewRow);
AppRegistry.registerComponent('TableViewHeader', () => TableViewHeader);
AppRegistry.registerComponent('TableViewFooter', () => TableViewFooter);
