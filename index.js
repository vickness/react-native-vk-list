/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import TableViewExampleCell from "./TableViewExampleCell";

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent('TableViewExampleCell', () => TableViewExampleCell);
