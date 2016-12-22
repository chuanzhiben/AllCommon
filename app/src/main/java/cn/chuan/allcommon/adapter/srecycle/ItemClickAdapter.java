package cn.chuan.allcommon.adapter.srecycle;

import android.content.Context;

import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;

import cn.chuan.allcommon.R;
import cn.chuan.allcommon.bean.MultipleItemBean;

/**
 * Created by super南仔 on 07/28/16.
 * blog: http://supercwn.github.io/
 * GitHub: https://github.com/supercwn
 */
public class ItemClickAdapter extends SuperBaseAdapter<MultipleItemBean> {

    public ItemClickAdapter(Context context, List<MultipleItemBean> data) {
        super(context, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultipleItemBean item, int position) {
        holder.setText(R.id.name_tv,item.getName())
                .setOnClickListener(R.id.name_tv,new OnItemChildClickListener())
                .setOnLongClickListener(R.id.image_iv,new OnItemChildLongClickListener());
    }

    @Override
    protected int getItemViewLayoutId(int position, MultipleItemBean item) {
        return R.layout.adapter_item_click_layout;
    }
}
