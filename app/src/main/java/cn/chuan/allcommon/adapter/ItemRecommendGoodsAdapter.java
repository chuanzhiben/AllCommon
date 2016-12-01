package cn.chuan.allcommon.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.chuan.allcommon.R;
import cn.chuan.allcommon.bean.RecommendGoodsBean;

/**
 * item页底部推荐商品适配器
 */
public class ItemRecommendGoodsAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<RecommendGoodsBean> data;

    public ItemRecommendGoodsAdapter(Context context, List<RecommendGoodsBean> data) {
        this.context = context;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<RecommendGoodsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<RecommendGoodsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public List<RecommendGoodsBean> getData() {
        return this.data;
    }

    public void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_recommend_goods_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RecommendGoodsBean recommendGoods = data.get(position);
        holder.tvGoodsName.setText(recommendGoods.getTitle());
        holder.tvGoodsPrice.setText("￥" + recommendGoods.getCurrentPrice());
        holder.sdvGoods.setImageURI(Uri.parse(recommendGoods.getImag()));
        holder.tvGoodsOldPrice.setText("￥" + recommendGoods.getPrice());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.sdv_goods)
        SimpleDraweeView sdvGoods;
        @Bind(R.id.tv_goods_name)
        TextView tvGoodsName;
        @Bind(R.id.tv_goods_price)
        TextView tvGoodsPrice;
        @Bind(R.id.tv_goods_old_price)
        TextView tvGoodsOldPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
