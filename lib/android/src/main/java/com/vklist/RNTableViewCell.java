package com.vklist;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.uimanager.ThemedReactContext;

public class RNTableViewCell extends LinearLayout {

    private ReactRootView mReactRootView;

    public RNTableViewCell(ThemedReactContext context, ReactInstanceManager reactInstanceManager, String identifier, Object item, int index) {
        super(context);
        if (mReactRootView == null) {
            Bundle bundle = getBundle(item, index);
            mReactRootView = new ReactRootView(context);
            mReactRootView.startReactApplication(reactInstanceManager, identifier, bundle);
            mReactRootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            addView(mReactRootView);
        }
    }

    public void setDataAndIndex(Object item, int index) {
        Bundle bundle = getBundle(item, index);
        mReactRootView.setAppProperties(bundle);
    }

    public Bundle getBundle(Object item, int index) {
        Bundle bundle = new Bundle();
        bundle.putInt("section", 0);
        bundle.putInt("row", index);
        bundle.putString("data", item.toString());
        return bundle;
    }
}
