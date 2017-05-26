package org.redborn.csatlatte.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.redborn.csatlatte.android.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by admin on 2017-05-26.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context = null;
    public ArrayList<ListData> listData = new ArrayList<ListData>();

    public ListViewAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);

            holder.icon = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.title = (TextView) convertView.findViewById(R.id.buttonTitle);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListData data = listData.get(position);

        if (data.icon != null) {
            holder.icon.setVisibility(View.VISIBLE);
            holder.icon.setImageDrawable(data.icon);
        } else {
            holder.icon.setVisibility(View.GONE);
        }

        holder.title.setText(data.title);

        return convertView;
    }

    public void addItem(Drawable icon, String title) {
        ListData addInfo = null;
        addInfo = new ListData();
        addInfo.icon = icon;
        addInfo.title = title;

        listData.add(addInfo);
    }

    public void remove(int position) {
        listData.remove(position);
        dataChange();
    }

    public void sort() {
        Collections.sort(listData, ListData.ALPHA_COMPARATOR);
        dataChange();
    }

    public void dataChange() {
        notifyDataSetChanged();
    }
}
