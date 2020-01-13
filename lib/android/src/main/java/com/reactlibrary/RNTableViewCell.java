package com.reactlibrary;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactRootView;
import com.facebook.react.uimanager.ThemedReactContext;

public class RNTableViewCell extends LinearLayout {

    private ReactRootView mReactRootView;

    public RNTableViewCell(ThemedReactContext context, String identifier) {
        super(context);
        if (mReactRootView == null) {
            mReactRootView = new ReactRootView(context);
            ReactApplication application = (ReactApplication) context.getCurrentActivity().getApplication();
            mReactRootView.startReactApplication(application.getReactNativeHost().getReactInstanceManager(), identifier);
            mReactRootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            addView(mReactRootView);
        }
    }

    public void setDataAndIndex(Object item, int index) {
        Bundle bundle = new Bundle();
        bundle.putInt("section", 0);
        bundle.putInt("row", index);
        bundle.putString("data", item.toString());
        mReactRootView.setAppProperties(bundle);
    }
}
