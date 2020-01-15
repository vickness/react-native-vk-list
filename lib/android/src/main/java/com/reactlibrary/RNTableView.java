package com.reactlibrary;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;
import java.util.Map;

public class RNTableView extends ListView {

    private RNAdapter adapter;
    private ThemedReactContext context;
    private ReactRootView headerView;
    private ReactRootView footerView;
    private ReactInstanceManager reactInstanceManager;
    private Integer headerHeight;
    private Integer footerHeight;
    private Bundle headerData;
    private Bundle footerData;

    public RNTableView(ThemedReactContext context) {
        super(context);
        this.context = context;
        ReactApplication application = (ReactApplication) context.getCurrentActivity().getApplication();
        this.reactInstanceManager = application.getReactNativeHost().getReactInstanceManager();
        this.adapter = new RNAdapter(context, this.reactInstanceManager);
        this.setAdapter(this.adapter);
    }

    public void setRowModule(String string) {
        this.adapter.setIdentifier(string);
    }

    public void setRowHeight(Integer integer) {
        this.adapter.setRowHeight(integer);
    }

    public void setRowData(ArrayList list) {
        this.adapter.setData(list);
        this.adapter.notifyDataSetChanged();
    }

    public void setHeaderModule(String string) {
        if (headerView == null) {

            headerView = new ReactRootView(this.context);
            headerView.startReactApplication(this.reactInstanceManager, string, headerData);
            addHeaderView(headerView);

            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.height = this.headerHeight;
            headerView.setLayoutParams(layoutParams);
        }
    }

    public void setHeaderHeight(Integer integer) {
        this.headerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, this.context.getResources().getDisplayMetrics());
    }

    public void setHeaderData(Map map) {
        Bundle bundle  = new Bundle();
        bundle.putString("data", map.toString());
        headerData = bundle;
    }

    public void setFooterModule(String string) {
        if (footerView == null) {

            footerView = new ReactRootView(this.context);
            footerView.startReactApplication(this.reactInstanceManager, string, footerData);
            addFooterView(footerView);

            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.height = this.footerHeight;
            footerView.setLayoutParams(layoutParams);
        }
    }

    public void setFooterHeight(Integer integer) {
        this.footerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, this.context.getResources().getDisplayMetrics());
    }

    public void setFooterData(Map map) {
        Bundle bundle  = new Bundle();
        bundle.putString("data", map.toString());
        footerData = bundle;
    }
}
