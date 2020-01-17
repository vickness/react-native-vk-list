package com.vklist;

import android.content.Context;

import com.scwang.smartrefresh.layout.footer.ClassicsFooter;

public class RNRefreshFooter extends ClassicsFooter {

    public RNRefreshFooter(Context context) {
        super(context);
        setDrawableSize(16);
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
