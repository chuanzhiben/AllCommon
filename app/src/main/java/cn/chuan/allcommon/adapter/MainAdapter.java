package cn.chuan.allcommon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.chuan.allcommon.R;

/**
 * Created by chuan on 16/11/29.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater mLayoutInflater;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.item_list_main, viewGroup,false);
            holder.itemData = (TextView) view.findViewById(R.id.itemData);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.itemData.setText(list.get(i));
        return view;
    }

    static class ViewHolder {
        TextView itemData;
    }
}
