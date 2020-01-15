package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.Map;

public class RNTableViewManager extends SimpleViewManager <RNTableView> {

    public static final String REACT_CLASS = "RNTableView";
    ReactApplicationContext mCallerContext;

    public RNTableViewManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNTableView createViewInstance(ThemedReactContext reactContext) {
        return new RNTableView(reactContext);
    }

    @ReactProp(name = "rowModule")
    public void setRowModule(RNTableView view, String string) {
        view.setRowModule(string);
    }

    @ReactProp(name = "rowData")
    public void setRowData(RNTableView view, ReadableArray list) {
        ArrayList<Object> arrayList = list.toArrayList();
        view.setRowData(arrayList);
    }

    @ReactProp(name = "rowHeight")
    public void setRowHeight(RNTableView view, Integer value) {
        view.setRowHeight(value);
    }


    @ReactProp(name = "headerModule")
    public void setHeaderModule(RNTableView view, String string) {
        view.setHeaderModule(string);
    }

    @ReactProp(name = "headerHeight")
    public void setHeaderHeight(RNTableView view, Integer value) {
        view.setHeaderHeight(value);
    }

    @ReactProp(name = "headerData")
    public void setHeaderData(RNTableView view, ReadableMap value) {
        Map map = value.toHashMap();
        view.setHeaderData(map);
    }


    @ReactProp(name = "footerModule")
    public void setFooterModule(RNTableView view, String string) {
        view.setFooterModule(string);
    }

    @ReactProp(name = "footerHeight")
    public void setFooterHeight(RNTableView view, Integer value) {
        view.setFooterHeight(value);
    }

    @ReactProp(name = "footerData")
    public void setFooterData(RNTableView view, ReadableMap value) {
        Map map = value.toHashMap();
        view.setFooterData(map);
    }
}
