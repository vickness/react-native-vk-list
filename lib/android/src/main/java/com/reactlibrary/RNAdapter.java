package com.reactlibrary;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;

public class RNAdapter extends BaseAdapter {

    private ThemedReactContext context;
    private ArrayList arrayList;
    private String identifier;
    private Integer rowHeight;

    public RNAdapter(ThemedReactContext context) {
        this.context = context;
        this.arrayList = new ArrayList();
    }

    public void setIdentifier(String string) {
        this.identifier = string;
    }

    public void setRowHeight(Integer integer) {
        this.rowHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, integer, context.getResources().getDisplayMetrics());
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
        if (cell == null) {
            cell = new RNTableViewCell(this.context, this.identifier);
            cell.setMinimumHeight(this.rowHeight);
            cell.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        Object item = arrayList.get(position);
        cell.setDataAndIndex(item, position);
        return cell;
    }
}
