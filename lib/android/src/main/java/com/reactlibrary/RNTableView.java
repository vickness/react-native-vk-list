package com.reactlibrary;

import android.widget.ListView;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;

public class RNTableView extends ListView {

    private RNAdapter adapter;

    public RNTableView(ThemedReactContext context) {
        super(context);
        this.adapter = new RNAdapter(context);
        this.setAdapter(this.adapter);
    }

    public void setIdentifier(String string) {
        this.adapter.setIdentifier(string);
    }

    public void setRowHeight(Integer integer) {
        this.adapter.setRowHeight(integer);
    }

    public void setData(ArrayList list) {
        this.adapter.setData(list);
        this.adapter.notifyDataSetChanged();
    }
}
