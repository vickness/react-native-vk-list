package com.vklist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.AbsListView;

import android.widget.ListView;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.*;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Map;

public class RNTableView extends SmartRefreshLayout {

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new RNRefreshHeader(context);
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new RNRefreshFooter(context);
            }
        });
    }

    private ListView listView;
    private RNAdapter adapter;
    private ThemedReactContext context;
    private ReactRootView headerView;
    private ReactRootView footerView;
    private ReactInstanceManager reactInstanceManager;
    private Integer headerHeight;
    private Integer footerHeight;
    private Bundle headerData;
    private Bundle footerData;
    private String headerModule;
    private String footerModule;
    private RCTEventEmitter eventEmitter;

    public RNTableView(final ThemedReactContext context) {
        super(context);
        this.context = context;
        this.eventEmitter = context.getJSModule(RCTEventEmitter.class);

        setEnableLoadMoreWhenContentNotFull(false);
        setEnableAutoLoadMore(false);

        ReactApplication application = (ReactApplication) context.getCurrentActivity().getApplication();
        this.reactInstanceManager = application.getReactNativeHost().getReactInstanceManager();

        this.listView = new ListView(context);
        setRefreshContent(this.listView);

        this.adapter = new RNAdapter(context, this.reactInstanceManager);
        this.listView.setAdapter(this.adapter);

        setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                eventEmitter.receiveEvent(getId(), "onHeaderRefresh", null);
            }
        });

        setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                eventEmitter.receiveEvent(getId(), "onFooterRefresh", null);
            }
        });
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
        this.headerModule = string;
        this.context.runOnUiQueueThread(new Runnable() {
            @Override
            public void run() {
                creatHeaderView();
            }
        });
    }

    public void setHeaderHeight(Integer integer) {
        this.headerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, this.context.getResources().getDisplayMetrics());
    }

    public void setHeaderData(Map map) {
        ReadableMap readableMap = Arguments.makeNativeMap(map);
        headerData = Arguments.toBundle(readableMap);
    }

    public void setFooterModule(String string) {
        this.footerModule = string;
        this.context.runOnUiQueueThread(new Runnable() {
            @Override
            public void run() {
                creatFooterView();
            }
        });
    }

    public void setFooterHeight(Integer integer) {
        this.footerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, this.context.getResources().getDisplayMetrics());
    }

    public void setFooterData(Map map) {
        ReadableMap readableMap = Arguments.makeNativeMap(map);
        footerData = Arguments.toBundle(readableMap);
    }

    public void setShowSeparator(Boolean value) {
        if (value) {
        } else {
            this.listView.setDividerHeight(0);
        }
    }

    public void creatHeaderView() {
        if (headerView == null) {
            headerView = new ReactRootView(this.context);
            headerView.startReactApplication(this.reactInstanceManager, this.headerModule, this.headerData);
            this.listView.addHeaderView(headerView);
        }
        if (this.headerHeight > 0) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.height = this.headerHeight;
            headerView.setLayoutParams(layoutParams);
        }
    }

    public void creatFooterView() {
        if (footerView == null) {
            footerView = new ReactRootView(this.context);
            footerView.startReactApplication(this.reactInstanceManager, this.footerModule, this.footerData);
            this.listView.addFooterView(footerView);
        }
        if (this.footerHeight > 0) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.height = this.footerHeight;
            footerView.setLayoutParams(layoutParams);
        }
    }

    public void setEnableHeaderRefresh(Boolean value) {
        setEnableRefresh(value);
    }

    public void setEnableFooterRefresh(Boolean value) {
        setEnableLoadMore(value);
    }

    public void startHeaderRefresh() {
        autoRefresh();
    }

    public void stopHeaderRefresh() {
        finishRefresh();
    }

    public void startFooterRefresh() {
        autoLoadMore();
    }

    public void stopFooterRefresh() {
        finishLoadMore();
    }

    public void stopFooterRefreshWithNoData() {
        finishLoadMoreWithNoMoreData();
    }


    @Override
    public void requestLayout() {
        super.requestLayout();
        post(new Runnable(){
            @Override
            public void run() {
                measure(
                        MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY)
                );
                layout(getLeft(), getTop(), getRight(), getBottom());
            }
        });
    }
}
