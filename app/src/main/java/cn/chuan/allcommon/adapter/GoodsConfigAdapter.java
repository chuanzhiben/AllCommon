package cn.chuan.allcommon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.bean.GoodsConfigBean;

/**
 * 商品详情里的规格参数数据适配器
 */
public class GoodsConfigAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<GoodsConfigBean> data;

    public GoodsConfigAdapter(Context context, List<GoodsConfigBean> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    public void setData(List<GoodsConfigBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.config_listview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GoodsConfigBean config = data.get(position);
        holder.tvConfigKey.setText(config.getKeyProp());
        holder.tvConfigValue.setText(config.getValue());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_config_key)
        TextView tvConfigKey;
        @Bind(R.id.tv_config_value)
        TextView tvConfigValue;
        @Bind(R.id.proValue)
        LinearLayout proValue;
        @Bind(R.id.pro_line)
        LinearLayout proLine;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
