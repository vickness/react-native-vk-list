package com.vklist;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;

public class RNAdapter extends BaseAdapter {

    private ThemedReactContext context;
    private ArrayList arrayList;
    private String identifier;
    private Integer rowHeight;
    private ReactInstanceManager reactInstanceManager;

    public RNAdapter(ThemedReactContext context, ReactInstanceManager reactInstanceManager) {
        this.context = context;
        this.reactInstanceManager = reactInstanceManager;
        this.arrayList = new ArrayList();
    }

    public void setIdentifier(String string) {
        this.identifier = string;
    }

    public void setRowHeight(Integer integer) {
        this.rowHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, this.context.getResources().getDisplayMetrics());
    }

    public void setData(ArrayList list) {
        this.arrayList = list;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RNTableViewCell cell = (RNTableViewCell) convertView;
        Object item = arrayList.get(position);
        if (cell == null) {
            cell = new RNTableViewCell(this.context, this.reactInstanceManager, this.identifier, item, position);
            cell.setMinimumHeight(this.rowHeight);
            cell.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            cell.setDataAndIndex(item, position);
        }
        return cell;
    }
}
