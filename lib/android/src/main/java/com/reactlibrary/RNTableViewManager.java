package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;

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

    @ReactProp(name = "identifier")
    public void setIdentifier(RNTableView view, String string) {
        view.setIdentifier(string);
    }

    @ReactProp(name = "data")
    public void setData(RNTableView view, ReadableArray list) {
        ArrayList<Object> arrayList = list.toArrayList();
        view.setData(arrayList);
    }

    @ReactProp(name = "rowHeight")
    public void setRowHeight(RNTableView view, Integer value) {
        view.setRowHeight(value);
    }
}
