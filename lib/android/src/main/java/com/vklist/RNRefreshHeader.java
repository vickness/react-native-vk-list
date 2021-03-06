package com.vklist;

import android.content.Context;

import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class RNRefreshHeader extends ClassicsHeader {

    public RNRefreshHeader(Context context) {
        super(context);
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
