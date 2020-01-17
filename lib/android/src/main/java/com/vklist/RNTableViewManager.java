package com.vklist;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

public class RNTableViewManager extends SimpleViewManager <RNTableView> {

    public static final String REACT_CLASS = "RNTableView";
    ReactApplicationContext mCallerContext;

    public static final int startHeaderRefresh = 1;
    public static final int stopHeaderRefresh = 2;
    public static final int startFooterRefresh = 3;
    public static final int stopFooterRefresh = 4;
    public static final int stopFooterRefreshWithNoData = 5;

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
        ArrayList arrayList = list.toArrayList();
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

    @ReactProp(name = "headerHeight", defaultInt = 0)
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

    @ReactProp(name = "footerHeight", defaultInt = 0)
    public void setFooterHeight(RNTableView view, Integer value) {
        view.setFooterHeight(value);
    }

    @ReactProp(name = "footerData")
    public void setFooterData(RNTableView view, ReadableMap value) {
        Map map = value.toHashMap();
        view.setFooterData(map);
    }

    @ReactProp(name = "enableHeaderRefresh")
    public void setEnableHeaderRefresh(RNTableView view, Boolean value) {
        view.setEnableHeaderRefresh(value);
    }

    @ReactProp(name = "enableFooterRefresh")
    public void setEnableFooterRefresh(RNTableView view, Boolean value) {
        view.setEnableFooterRefresh(value);
    }

    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                "startHeaderRefresh", startHeaderRefresh,
                "stopHeaderRefresh", stopHeaderRefresh,
                "startFooterRefresh", startFooterRefresh,
                "stopFooterRefresh", stopFooterRefresh,
                "stopFooterRefreshWithNoData", stopFooterRefreshWithNoData
        );
    }

    @Override
    public void receiveCommand(@Nonnull RNTableView root, int commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case startHeaderRefresh:
                root.startHeaderRefresh();
                break;
            case stopHeaderRefresh:
                root.stopHeaderRefresh();
                break;
            case startFooterRefresh:
                root.startFooterRefresh();
                break;
            case stopFooterRefresh:
                root.stopFooterRefresh();
                break;
            case stopFooterRefreshWithNoData:
                root.stopFooterRefreshWithNoData();
                break;
        }
    }


    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put("onHeaderRefresh", MapBuilder.of("registrationName", "onHeaderRefresh"))
                .put("onFooterRefresh", MapBuilder.of("registrationName", "onFooterRefresh"))
                .build();
    }
}
